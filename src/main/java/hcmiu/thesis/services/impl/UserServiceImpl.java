package hcmiu.thesis.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hcmiu.thesis.commons.SystemMessage;
import hcmiu.thesis.entities.Account;
import hcmiu.thesis.repositories.AccountReposity;
import hcmiu.thesis.services.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	AccountReposity accountReposity;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Account account = accountReposity.findActiveAccountByUsername(username);
		
		UserBuilder builder;
		if (account != null) {
			builder = User.withUsername(username);
			builder.password(account.getPassword());
			if (account.getRole() == 1) {
				builder.roles("ADMIN");
			} else if (account.getRole() == 2) {
				builder.roles("USER");
			}
		} else {
			throw new UsernameNotFoundException(SystemMessage.USER_NOT_FOUND);
		}
		return builder.build();
	}

	@Override
	public Account changeStatus(String username, Integer status) {
		// TODO Auto-generated method stub
		Optional<Account> accountCheck = Optional.ofNullable(accountReposity.findByUsername(username));
		if (accountCheck.isEmpty()) {
			throw new UsernameNotFoundException(SystemMessage.USER_NOT_FOUND);
		} else {
			Account account = accountCheck.get();
			account.setStatus(status);
			return accountReposity.save(account);
		}
	}
}

package hcmiu.thesis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmiu.thesis.entities.User;
import hcmiu.thesis.repositories.AccountReposity;
import hcmiu.thesis.repositories.ProfileRepository;
import hcmiu.thesis.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepo;
	@Autowired
	AccountReposity accountRepo;
	
	@Override
	public User getPersonalInfo(Integer userId) {
		// TODO Auto-generated method stub
		return profileRepo.existsById(userId) ? profileRepo.findById(userId).get() : new User();
	}
	
	@Override
	public User getPersonalInfoByUsername (String username) {
		Integer userId = accountRepo.findAll().stream().filter(each -> each.getUsername().equals(username)).findFirst().get().getAccountId();
		return getPersonalInfo(userId);
	}

}

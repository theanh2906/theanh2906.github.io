package hcmiu.thesis.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import hcmiu.thesis.commons.UrlConstant;
import hcmiu.thesis.handlers.CustomAccessDeniedHandler;
import hcmiu.thesis.handlers.CustomLogoutHandler;
import hcmiu.thesis.services.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan ("hcmiu.thesis")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
    @Autowired
    public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
    
    @Bean
    LogoutSuccessHandler logoutSuccessHandler() {
    	return new CustomLogoutHandler();
    }
    
    @Bean
    AccessDeniedHandler accessDeniedHandler() {
    	return new CustomAccessDeniedHandler();
    }
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	};
	
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    
    @Bean
    public DaoAuthenticationProvider customerAuthenticationProvider() {
    	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    	authenticationProvider.setUserDetailsService(userDetailsService());
    	authenticationProvider.setPasswordEncoder(passwordEncoder());
    	return authenticationProvider;
    }
    
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customerAuthenticationProvider());
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(UrlConstant.HOME, UrlConstant.POST).permitAll()
			.antMatchers(UrlConstant.ADMIN).hasAnyRole("ADMIN")
			.antMatchers(UrlConstant.PROFILE).hasAnyRole("ADMIN", "USER")
		.and()
			.formLogin()
			.loginPage("/login")
			.usernameParameter("username").passwordParameter("password")
			.successHandler(authenticationSuccessHandler)
			.permitAll()
//			.failureUrl(ERROR)
		.and()
			.logout()
//			.logoutUrl(LOGOUT)
			.invalidateHttpSession(true)
			.logoutSuccessHandler(logoutSuccessHandler())
			.permitAll()
		.and()
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
		.and()
			.csrf()
			.disable();	
	}
}



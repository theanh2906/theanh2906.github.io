package hcmiu.thesis.services;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
	/**
	 * Check existence of user 
	 * @param String username
	 * @return true if exists/ false if not exists
	 */
	boolean checkExistAccount(String username);
	
	
	
}

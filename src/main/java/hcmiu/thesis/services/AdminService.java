package hcmiu.thesis.services;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
	/**
	 * Disable user account
	 * @param String username
	 */
	void disableAccount(String username);
}

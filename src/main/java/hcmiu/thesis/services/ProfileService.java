package hcmiu.thesis.services;

import hcmiu.thesis.entities.User;

public interface ProfileService {
	User getPersonalInfo (Integer userId);

	User getPersonalInfoByUsername(String username); 
}

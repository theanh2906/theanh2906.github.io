package hcmiu.thesis.services;

import hcmiu.thesis.entities.Account;

public interface UserService {

	Account changeStatus(String username, Integer status);

}

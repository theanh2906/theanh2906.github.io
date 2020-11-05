package hcmiu.thesis.services;

import hcmiu.thesis.commons.EmailTypes;

public interface MailService {
	void sendMail(String email, EmailTypes emailType, String username);
}

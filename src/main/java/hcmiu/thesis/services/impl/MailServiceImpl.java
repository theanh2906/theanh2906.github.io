package hcmiu.thesis.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import hcmiu.thesis.commons.EmailTypes;
import hcmiu.thesis.services.MailService;
import hcmiu.thesis.utils.UrlUtil;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	

	@Override
	public void sendMail(String email, EmailTypes emailType, String username) {
		// TODO Auto-generated method stub
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(email);
			switch (emailType) {
			case SUCCESSFUL_REGISTRATION :
				String htmlMailRegistration = 
				  "<h1 style='color:red'>Please be kindly to follow this link below to change password for first time login:</h1>"
				+ "<br>"
				+ UrlUtil.createLink(EmailTypes.SUCCESSFUL_REGISTRATION, username);
				
				helper.setSubject("[THE ONLINE ARTICLE]Your registration is successful! Welcome to our family");
				message.setContent(htmlMailRegistration, "text/html");
				mailSender.send(message);
				break;
			case FORGOT_PASSWORD :
				String htmlMailForgot = 
				  "<h1>Please click the link below to set new password for your account</h1>"
				+ "<br>";
				break;
			default:
				break;
			}

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

}

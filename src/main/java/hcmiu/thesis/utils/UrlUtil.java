package hcmiu.thesis.utils;

import javax.servlet.http.HttpServletRequest;

import hcmiu.thesis.commons.EmailTypes;
import hcmiu.thesis.commons.SystemMessage;

public class UrlUtil {
	
	@SuppressWarnings("null")
	public static String createLink (EmailTypes emailTypes, String username) {
		String link = null;
		
		switch (emailTypes) {
		case SUCCESSFUL_REGISTRATION:
			link = SystemMessage.HOME_ROOT + "/change-password?username=" + username;

		default:
			break;
		}
		
		return link;
	}
}

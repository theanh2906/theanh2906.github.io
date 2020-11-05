package hcmiu.thesis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	
	@GetMapping("/login")
	public ModelAndView viewLogin() {
		ModelAndView mav = new ModelAndView("components/login");
		return mav;
	}
	
	@PostMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("components/login");
//		mav.addObject("message", attributeValue)
		return mav;
	}
}

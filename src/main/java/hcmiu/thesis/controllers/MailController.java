//package hcmiu.thesis.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@SpringBootApplication
//@RestController
//@RequestMapping("/mail")
//public class MailController {
//	
//	@Autowired
//	public JavaMailSender mailSender;
//	
//	public static void main(String[] args) {
//		SpringApplication.run(MailController.class, args);
//	}
//	
//	@RequestMapping("/send-mail")
//	@ResponseBody
//	public String sendEmail() {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo("theanh2906@gmail.com");
//		message.setSubject("Sending mail testing");
//		message.setText("<h1>This is test mail</h1>");
//		
//		mailSender.send(message);
//		return "Email sended!";
//	}
//}

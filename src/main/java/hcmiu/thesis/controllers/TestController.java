package hcmiu.thesis.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hcmiu.thesis.commons.EmailTypes;
import hcmiu.thesis.dtos.PostDTO;
import hcmiu.thesis.entities.Post;
import hcmiu.thesis.entities.User;
import hcmiu.thesis.repositories.AccountReposity;
import hcmiu.thesis.repositories.EntityManagerRepository;
import hcmiu.thesis.services.MailService;
import hcmiu.thesis.services.PostService;
import hcmiu.thesis.services.ProfileService;
import hcmiu.thesis.services.RatingService;
import hcmiu.thesis.services.UserService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	EntityManagerRepository entityManager;
	
	@Autowired
	ProfileService profileService;
	
	@Autowired
	AccountReposity accountRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	RatingService ratingService;
	
	@Autowired
	JavaMailSender emailSender;
	
	@Autowired
	MailService mailService;
	
	@GetMapping("/{cat}")
	@ResponseBody
	public List<PostDTO> getCategory(@PathVariable String cat) {
		return entityManager.getAllPostsByCategory(cat);
	}
	
	@GetMapping("/username/{username}")
	@ResponseBody
	public User getUserProfile (@PathVariable String username) {
		return profileService.getPersonalInfoByUsername(username);
	}
	
	@GetMapping("/showpass/{username}")
	@ResponseBody
	public String showPass(@PathVariable String username) {
		return accountRepo.findAll().stream().filter(e -> e.getUsername().equals(username)).findFirst().get().getPassword();
	}
	
	@GetMapping("/disable/{username}")
	@ResponseBody
	public String disableAccount(@PathVariable String username) {
		userService.changeStatus(username, 0);
		return "Account "+username+" is disabled!";
	}
	
	@GetMapping("/enable/{username}")
	@ResponseBody
	public String enableAccount(@PathVariable String username) {
		userService.changeStatus(username, 1);
		return "Account "+username+" is enabled!";
	}
	
	@PostMapping("/delete_post/{id}")
	@ResponseBody
	public String deletePost (@PathVariable("id") Integer id) {
		return postService.deletePostById(id);
	}
	
	@GetMapping("/overall/{id}")
	@ResponseBody
	public Double calculateOverall (@PathVariable Integer id) {
		return ratingService.calculateOverall(id);
	}
	
	@GetMapping("/update_overall")
	@ResponseBody
	public List<Post> updateOverall () {
		return ratingService.updateOverall();
	}
	
	@RequestMapping(value = "/multiple-delete", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> getMultiple (@RequestBody String raw) {
		List<Integer> listInt = new ArrayList<>();
		String[] arr = raw.replace("index=", "").replace("&", "").split("");
		for(String e : arr) {
			listInt.add(Integer.parseInt(e));
		}
		return listInt;
	}

	@GetMapping("/login-page")
	public ModelAndView showLoginForm() {
		return new ModelAndView("/components/login");
	}
	
	@RequestMapping("/send-mail")
	@ResponseBody
	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("theanh2906@gmail.com");
		message.setSubject("Sending mail testing");
		message.setText("<h1>This is test mail</h1>");
		
		this.emailSender.send(message);
		return "Email sent!";
	}
	
	@RequestMapping("/send_link")
	@ResponseBody
	public String sendLink() {
		mailService.sendMail("theanh2906@gmail.com", EmailTypes.SUCCESSFUL_REGISTRATION, "theanh2906");
		return "Email sent!";
	}
	
	
}

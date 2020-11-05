package hcmiu.thesis.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import hcmiu.thesis.commons.PostStatus;
import hcmiu.thesis.dtos.CategoryDTO;
import hcmiu.thesis.dtos.CommentDTO;
import hcmiu.thesis.dtos.PostDTO;
import hcmiu.thesis.dtos.TestDTO;
import hcmiu.thesis.dtos.YearDTO;
import hcmiu.thesis.entities.Input;
import hcmiu.thesis.entities.User;
import hcmiu.thesis.services.CommentService;
import hcmiu.thesis.services.PostService;
import hcmiu.thesis.services.ProfileService;
import hcmiu.thesis.services.RatingService;
import hcmiu.thesis.utils.CollectionUtil;
import hcmiu.thesis.utils.TimeUtil;

@Controller
@RequestMapping("/")
public class PostController {
	@Autowired
	PostService postService;
	
	@Autowired
	RatingService ratingService;
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	ProfileService profileService;
	
	
	@GetMapping("/new")
	public ModelAndView viewForm () {
		return new ModelAndView("home","input", new Input());
	}
	
	@GetMapping("/header")
	public ModelAndView viewNav() {
		return new ModelAndView("components/header");
	}
	
	@GetMapping("/footer")
	public ModelAndView viewFooter() {
		return new ModelAndView("components/footer");
	}
	
//	@GetMapping("/test")
//	public String doTool () {
//		return "components/carousel";
//	}
	
	@GetMapping("/home")
	public ModelAndView viewBlog(@RequestParam(required = false) String category, @RequestParam(required = false) Integer year) {
		ModelAndView mav = new ModelAndView();
		Optional<String> checkCategory = Optional.ofNullable(category);
		Optional<Integer> checkYear = Optional.ofNullable(year);
		List<PostDTO> listPost = new ArrayList<>();
		if (checkCategory.isEmpty() && checkYear.isEmpty()) {
			listPost = postService.getAllPostsByStatus(1);
		} else if (checkYear.isPresent() && checkCategory.isEmpty()) {
			listPost = postService.getAllPostsByYear(1, year);
			mav.addObject("message","Year: "+ year);
		} else if (checkYear.isEmpty() && checkCategory.isPresent()){
			listPost = postService.getAllPostsByCategory(1, category);
			mav.addObject("message","Category: "+ category);
		}
		
		mav.setViewName("home");
		CollectionUtil.sortDateDecs(listPost);
		mav.addObject("listPost",listPost);
		return mav;
	}
	
	@GetMapping("/post")
	public ModelAndView viewPost(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("post");
		PostDTO post = postService.getPostById(id);
		mav.addObject("listComments", commentService.getCommentsDtoByPostId(id));
		mav.addObject("listRating", ratingService.getRatingsByPostIdFilterByStar(id));
		mav.addObject("listPercentage", ratingService.getPercentageOfRating(ratingService.getRatingsByPostIdFilterByStar(id)));
		mav.addObject("post", post);
		return mav;
	}
	
	@GetMapping("/rating")
	public ModelAndView viewRating() {
		return new ModelAndView("components/Rating");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/update")
	@ResponseBody
	public ResponseEntity<CommentDTO> test(@RequestParam Integer id) {
		return new ResponseEntity(commentService.getCommentsDtoByPostId(id), HttpStatus.OK);
	}
	
	@GetMapping("/profile")
	public ModelAndView showProfile(Authentication auth) {
		ModelAndView mav = new ModelAndView("profile");
		User profile = profileService.getPersonalInfoByUsername(auth.getName().toString());
		List<PostDTO> listPosts = postService.getAllPosts().stream().filter(each -> each.getUserId().equals(profile.getUserId()) && each.getStatusName().equals("Active")).collect(Collectors.toList());
		mav.addObject("profile", profile);
		mav.addObject("numberOfPosts", postService.getAllPostsByUsername(auth.getName().toString()).size());
//		mav.addObject("input", new TestDTO());
		mav.addObject("listPosts", listPosts);
		return mav;
	}
	
	
	@GetMapping("/403")
	public String view403 () {
		return "access_denied";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String viewAdmin() {
		return "This is admin page";
	}
	
	@PostMapping("/delete")
	public String deletePosts (@RequestBody String raw) {
		List<Integer> listInt = new ArrayList<>();
		String[] arr = raw.replace("index=", "").replace("&", "").split("");
		for(String e : arr) {
			listInt.add(Integer.parseInt(e));
		}
		postService.changePostStatusById(listInt, 2);
		return "profile";
	}
	
	@ModelAttribute
	public void addAttribute(ModelMap model) {
		Function<List<PostDTO>, List<YearDTO>> allYears = (listArticle) -> {
			List<YearDTO> listYears = new ArrayList<>();
			List<Integer> years = listArticle.stream().map(each -> TimeUtil.getYear(each.getCreateTime())).distinct().sorted(CollectionUtil.SORT_DESC).collect(Collectors.toList());
			years.forEach(year -> {
				listYears.add(new YearDTO(year, listArticle.stream().filter(p -> TimeUtil.getYear(p.getCreateTime()).equals(year)).collect(Collectors.toList()).size()));
			});
			return listYears;
		};
		List<PostDTO> listArticle = postService.getAllPostsByStatus(1);
		List<YearDTO> listYears = allYears.apply(listArticle);
		List<String> categories = listArticle.stream().map(each -> each.getCategoryName()).distinct().collect(Collectors.toList());
		List<CategoryDTO> allCategories = categories.stream().map(each -> new CategoryDTO(each, postService.getAllPostsByCategory(1, each).size())).collect(Collectors.toList());
		model.addAttribute("allCategories", allCategories);
		model.addAttribute("listYears", listYears);
	}
}

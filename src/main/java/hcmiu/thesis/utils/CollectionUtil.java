package hcmiu.thesis.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hcmiu.thesis.dtos.PostDTO;
import hcmiu.thesis.services.PostService;


public class CollectionUtil {
	
	@Autowired
	static PostService postService;
	
	public static void sortDateDecs(List<PostDTO> list) {
		Collections.sort(list,(a,b) -> {
			return b.getCreateTime().compareTo(a.getCreateTime());
		});
	}
	
	public static void sortDateAsc(List<PostDTO> list) {
		Collections.sort(list,(a,b) -> {
			return a.getCreateTime().compareTo(b.getCreateTime());
		});
	}
	
	public static Comparator<Integer> SORT_DESC = (a,b) -> {
		return b-a;
	};
	
	public static Comparator<Integer> SORT_ASC = (a,b) -> {
		return a-b;
	};
	
	public static Integer countByCategory(String category) {
		return postService.getAllPostsByCategory(1, category).size();
	}
}

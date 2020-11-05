package hcmiu.thesis.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import hcmiu.thesis.entities.Post;
import hcmiu.thesis.entities.Rating;


public interface RatingService {
	
	List<Rating> getAllRatings ();
	
	List<Rating> getRatingsByPostId (Integer id);
	
	Map<String, Integer> getRatingsByPostIdFilterByStar(Integer id) ;
	
	Double calculateOverall(Integer id);
	
	List<Post> updateOverall ();

	Map<String, String> getPercentageOfRating(Map<String, Integer> map);
}

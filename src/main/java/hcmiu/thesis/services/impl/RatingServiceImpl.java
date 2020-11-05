package hcmiu.thesis.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmiu.thesis.entities.Post;
import hcmiu.thesis.entities.Rating;
import hcmiu.thesis.repositories.PostRespository;
import hcmiu.thesis.repositories.RatingRepository;
import hcmiu.thesis.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Autowired
	PostRespository postRepo;
	
	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}
	@Override
	public List<Rating> getRatingsByPostId(Integer id) {
		// TODO Auto-generated method stub
		return getAllRatings().stream().filter(each -> each.getPostId() == id).collect(Collectors.toList());
	}
	@Override
	public Map<String, Integer> getRatingsByPostIdFilterByStar(Integer id) {
		// TODO Auto-generated method stub
		Map<String, Integer> starMap = new HashMap<>();
		Integer star_1 = getRatingsByPostId(id).stream().filter(each -> each.getRating() == 1).collect(Collectors.toList()).size();
		Integer star_2 = getRatingsByPostId(id).stream().filter(each -> each.getRating() == 2).collect(Collectors.toList()).size();
		Integer star_3 = getRatingsByPostId(id).stream().filter(each -> each.getRating() == 3).collect(Collectors.toList()).size();
		Integer star_4 = getRatingsByPostId(id).stream().filter(each -> each.getRating() == 4).collect(Collectors.toList()).size();
		Integer star_5 = getRatingsByPostId(id).stream().filter(each -> each.getRating() == 5).collect(Collectors.toList()).size();
		
		starMap.put("star_1", star_1);
		starMap.put("star_2", star_2);
		starMap.put("star_3", star_3);
		starMap.put("star_4", star_4);
		starMap.put("star_5", star_5);
		starMap.put("total", getRatingsByPostId(id).size());
		
		return starMap;
	}
	@Override
	public Double calculateOverall(Integer id) {
		// TODO Auto-generated method stub
		List<Rating> listAllRatingsById = getRatingsByPostId(id);
		Double total = (double)listAllRatingsById.size();
		Double sum = (double)listAllRatingsById.stream().map(each -> each.getRating()).collect(Collectors.summingInt(Integer::intValue));
		
		Double average = Precision.round((sum/total), 1);
		return average.equals(Double.NaN) ? 0.0 : average;
	}
	
	@Override
	public Map<String, String> getPercentageOfRating(Map<String, Integer> map){
		Map<String, String> percentageMap = new HashMap<>();
		if(map.get("total")!=0) {
		Double one = Precision.round((double)(map.get("star_1")*100/map.get("total")), 1);
		Double two = Precision.round((double)(map.get("star_2")*100/map.get("total")), 1);
		Double three = Precision.round((double)(map.get("star_3")*100/map.get("total")), 1);
		Double four = Precision.round((double)(map.get("star_4")*100/map.get("total")), 1);
		Double five = Precision.round((double)(map.get("star_5")*100/map.get("total")), 1);
		
		percentageMap.put("star_1", one.toString()+'%');
		percentageMap.put("star_2", two.toString()+'%');
		percentageMap.put("star_3", three.toString()+'%');
		percentageMap.put("star_4", four.toString()+'%');
		percentageMap.put("star_5", five.toString()+'%');
		
		} else {
			percentageMap.put("star_1", "0" +'%');
			percentageMap.put("star_2", "0"+'%');
			percentageMap.put("star_3", "0"+'%');
			percentageMap.put("star_4", "0"+'%');
			percentageMap.put("star_5", "0"+'%');
		};
		
		return percentageMap;
	}
	@Override
	public List<Post> updateOverall() {
		// TODO Auto-generated method stub
		List<Post> updatedList = postRepo.findAll().stream().map(each -> {
			each.setOverall(calculateOverall(each.getPostId()));
			return each;
		}).collect(Collectors.toList());
		return postRepo.saveAll(updatedList);
	}
	
	

}

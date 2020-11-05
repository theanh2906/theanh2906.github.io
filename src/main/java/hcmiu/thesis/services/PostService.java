package hcmiu.thesis.services;

import java.util.List;

import hcmiu.thesis.dtos.PostDTO;
import hcmiu.thesis.entities.Post;

public interface PostService {
	String getSummary(String text, int sentenceNum);

	String getLSA(String text, int number);

	int getLastPage(int numberOfItem, int itemsPerPage);

	int getStartOfPagination(int page, int numberOfPaginationIndex);

	List<PostDTO> getAllPostsByStatus(Integer status);
	
	PostDTO getPostById(Integer id);
	
	List<PostDTO> getAllPostsByCategory(Integer status, String category);
	
	List<PostDTO> getAllPostsByYear(Integer status, Integer year);
	List<PostDTO> getAllPostsByUsername(String username);
	
	List<PostDTO> getAllPosts ();
	
	String deletePostById (Integer id);

	String changePostStatusById(Integer id, Integer status);

	String changePostStatusById(List<Integer> ids, Integer status);
}

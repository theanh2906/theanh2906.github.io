package hcmiu.thesis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmiu.thesis.commons.SystemMessage;
import hcmiu.thesis.dtos.PostDTO;
import hcmiu.thesis.entities.Post;
import hcmiu.thesis.repositories.EntityManagerRepository;
import hcmiu.thesis.repositories.PostRespository;
import hcmiu.thesis.repositories.SummarizationDao;
import hcmiu.thesis.services.PostService;
import hcmiu.thesis.utils.TimeUtil;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	
	private SummarizationDao summaryDao;
	
	@Autowired
	private EntityManagerRepository repository;
	
	@Autowired
	PostRespository postRepo;
	
	public PostDTO getPostById(Integer id) {
		return repository.getPostById(id);
	}
	
	@Override
	public List<PostDTO> getAllPostsByStatus(Integer status) {
        return repository.getAllPostsByStatus(status);
    }
    
	@Override
	public String getSummary(String text, int sentenceNum) {
		// TODO Auto-generated method stub
		return summaryDao.getSummary(text,sentenceNum);
	}
	@Override
	public String getLSA(String text, int number) {
		// TODO Auto-generated method stub
		return summaryDao.getLSA(text, number);
	}
	
       
//    public Article get() {
//    	Integer random = NumberUtil.random(1, 200);
//        return repo.findById(random).get();
//    }
//     
//    public void delete(Integer id) {
//        repo.deleteById(id);
//    }

	@Override
	public int getLastPage(int numberOfItem, int itemsPerPage) {
		int lastPage;

		if (numberOfItem % itemsPerPage == 0) {
			lastPage = numberOfItem / itemsPerPage;

		} else {
			lastPage = numberOfItem / itemsPerPage + 1;
		}
		return lastPage;
	}
	//method get start of pagination
	@Override
	public int getStartOfPagination(int page, int numberOfPaginationIndex) {
		int start;
		if (page == 0){
			return 1;
		}
		if (page % numberOfPaginationIndex == 0) {
			start = (page / numberOfPaginationIndex - 1) * numberOfPaginationIndex + 1;
		} else {
			start = (page / numberOfPaginationIndex) * numberOfPaginationIndex + 1;
		}
		return start;
	}

	@Override
	public List<PostDTO> getAllPostsByCategory(Integer status, String category) {
		// TODO Auto-generated method stub
		return getAllPostsByStatus(status).stream().filter(a -> a.getCategoryName().equals(category)).collect(Collectors.toList());
	}

	@Override
	public List<PostDTO> getAllPostsByYear(Integer status, Integer year) {
		// TODO Auto-generated method stub
		return getAllPostsByStatus(status).stream().filter(a -> TimeUtil.getYear(a.getCreateTime()).equals(year)).collect(Collectors.toList());
	}
	
	@Override
	public List<PostDTO> getAllPostsByUsername (String username) {
		return getAllPostsByStatus(1).stream().filter(each -> each.getUsername().equals(username)).collect(Collectors.toList());
	}

	@Override
	public List<PostDTO> getAllPosts() {
		// TODO Auto-generated method stub
		return repository.getAllPosts();
	}

	@Override
	public String deletePostById(Integer id) {
		// TODO Auto-generated method stub
		Boolean checkPost = postRepo.existsById(id);
		if (checkPost.equals(true)) {
			postRepo.deleteById(id);
			return SystemMessage.SUCCESSFUL_DELETE;
		} else {
			return SystemMessage.POST_NOT_FOUND;
		}
	}
	
	@Override
	public String changePostStatusById (Integer id, Integer status) {
		Boolean checkPost = postRepo.existsById(id);
		if (checkPost.equals(true)) {
			Post post = postRepo.findById(id).get();
			post.setStatusId(status);
			postRepo.save(post);
			return SystemMessage.SUCCESSFUL_DELETE;
		} else {
			return SystemMessage.POST_NOT_FOUND;
		}
	}

	@Override
	public String changePostStatusById(List<Integer> ids, Integer status) {
		// TODO Auto-generated method stub
		List<Post> listPost = postRepo.findAllById(ids);
		listPost.forEach(post -> {
			post.setStatusId(status);
		});
		return SystemMessage.SUCCESSFUL_DELETE;
	}


}

package hcmiu.thesis.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hcmiu.thesis.commons.PostQuery;
import hcmiu.thesis.dtos.CommentDTO;
import hcmiu.thesis.dtos.PostDTO;
import hcmiu.thesis.entities.User; 

@Repository
public class EntityManagerRepository {
	
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 0;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<PostDTO> getAllPosts() {
		Query query = entityManager.createQuery(PostQuery.GET_ALL_POSTS, PostDTO.class);
		return query.getResultList();
	}
	
	public PostDTO getPostById (Integer id) {
		return getAllPostsByStatus(ACTIVE).stream().filter(each -> each.getPostId().equals(id)).findFirst().get();
	}
	
	@SuppressWarnings("unchecked")
	public List<PostDTO> getAllPostsByStatus(Integer status) {
		Query query = entityManager.createQuery(PostQuery.GET_ALL_POSTS_BY_STATUS, PostDTO.class);
		return query.setParameter(1, status).getResultList();
	}
	
	public List<PostDTO> getAllPostsByCategory(String category ) {
		return getAllPostsByStatus(ACTIVE).stream().filter(each -> each.getCategoryName().equals(category)).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public List<CommentDTO> getAllComments () {
		Query query = entityManager.createQuery(PostQuery.GET_ALL_COMMENTS, CommentDTO.class);
		return query.getResultList();
	}
	
	
}

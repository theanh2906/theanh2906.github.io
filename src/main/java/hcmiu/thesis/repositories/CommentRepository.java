package hcmiu.thesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hcmiu.thesis.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, CrudRepository<Comment, Integer>{
	
}

package hcmiu.thesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hcmiu.thesis.entities.Post;

@Repository
public interface PostRespository extends CrudRepository<Post, Integer>, JpaRepository<Post, Integer> {
}

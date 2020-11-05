package hcmiu.thesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hcmiu.thesis.entities.User;

@Repository
public interface ProfileRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer>{
	
}

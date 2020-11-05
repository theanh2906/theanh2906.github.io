package hcmiu.thesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hcmiu.thesis.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>, CrudRepository<Rating, Integer>{

}

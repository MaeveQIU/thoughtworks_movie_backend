package com.thoughtworks.theater.repository;

import com.thoughtworks.theater.entity.Review;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
  @Query("SELECT * FROM movie_review WHERE movie_id = :id;")
  List<Review> findByMovieId(@Param("id") int movieId);
}

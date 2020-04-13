package com.thoughtworks.theater.repository;

import com.thoughtworks.theater.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer> {
}

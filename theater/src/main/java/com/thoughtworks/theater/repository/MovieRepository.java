package com.thoughtworks.theater.repository;

import com.thoughtworks.theater.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}

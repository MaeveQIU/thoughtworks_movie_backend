package com.thoughtworks.theater.service;

import com.thoughtworks.theater.entity.Movie;
import com.thoughtworks.theater.entity.Review;
import com.thoughtworks.theater.repository.MovieRepository;
import com.thoughtworks.theater.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

  @Autowired
  private MovieRepository movieRepo;

  @Autowired
  private ReviewRepository reviewRepo;

  public List<Movie> findByMovieNameLike(String input) {
    String title = "%" + input + "%";
    return movieRepo.findByTitle(title);
  }

  public List<Movie> getAllMovies() {
    return (List<Movie>)movieRepo.findAll();
  }

  public List<Review> getCommentsByMovieId(int movieId) {
    return reviewRepo.findByMovieId(movieId);
  }

  public List<Movie> getMoviesWithPagination(int page, int number) {
    int offset = (page - 1) * number;
    return movieRepo.findWithPagination(offset, number);
  }
}

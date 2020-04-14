package com.thoughtworks.theater.controller;
import com.thoughtworks.theater.entity.Movie;
import com.thoughtworks.theater.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("movies")
@RestController
public class MyController {
  //get all movie, return List<Movie>
  //search by movie name, return List<Movie>
  //get comments by movieId, return List<Review>

  // 传回去的值里genres等都是string，前端得改！
  @Autowired
  private TheaterService userService;

  @GetMapping("/get/all")
  public List<Movie> getAll() {
    return userService.getAllMovies();
  }

  /**
   * url send parameter, e.g. "get/page?page=2&number=50", will return records from 50 to 100.
   * @return List of Movie
   */
  @GetMapping("get/page")
  public ResponseEntity<List<Movie>> getWithPagination(@RequestParam("page") int page, @RequestParam("number") int number) {
    List<Movie> result = userService.getMoviesWithPagination(page, number);
    if (result.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/get/{title}")
  public List<Movie> getByTitle(@PathVariable String title) {
    List<Movie> movies = userService.findByMovieNameLike(title);
    if (movies.isEmpty()) {
      return null;
    } else {
      return movies;
    }
  }

}
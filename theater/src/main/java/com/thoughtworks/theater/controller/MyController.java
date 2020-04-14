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
  public ResponseEntity<List<Movie>> getAll() {
    List<Movie>  result = userService.getAllMovies();
    if (result.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
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

  @GetMapping("/search/{title}")
  public ResponseEntity<List<Movie>> getByTitle(@PathVariable String title) {
    List<Movie> result = userService.findByMovieNameLike(title);
    if (result.isEmpty()) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
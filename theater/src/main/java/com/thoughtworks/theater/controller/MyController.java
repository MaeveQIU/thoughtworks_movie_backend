package com.thoughtworks.theater.controller;
import com.thoughtworks.theater.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  //get all movie, return List<Movie>
  //search by movie name, return List<Movie>
  //get comments by movieId, return List<Review>

  // 传回去的值里genres等都是string，前端得改！
  @Autowired
  private TheaterService userService;

}
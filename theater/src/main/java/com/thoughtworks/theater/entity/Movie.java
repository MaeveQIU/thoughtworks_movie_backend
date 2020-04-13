package com.thoughtworks.theater.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("movie_basic")
public class Movie {
  @Id
  private int movieId;
  private String title;
  private int year;
  private String genres;
  private double rating;
  private String directors;
  private String casts;
  private String duration;
  private String image;
  private String countries;
  private String tags;
  private String summary;

//  private Set<Review> reviewList; //不要外键的话就不要在Movie里加review相关。

  //最好是所有property的constructor，先写这个方便测试
  public Movie(int movieId, String title) {
    this.movieId = movieId;
    this.title = title;
  }


}

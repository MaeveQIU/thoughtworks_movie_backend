package com.thoughtworks.theater.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("movie_review")
public class Review {
  @Id
  private int reviewId;
  private int movieId;
  private String authorProfile;
  private String authorName;
  private String review;

  public Review(int reviewId, int movieId, String authorProfile, String authorName, String review) {
    this.reviewId = reviewId;
    this.movieId = movieId;
    this.authorProfile = authorProfile;
    this.authorName = authorName;
    this.review = review;
  }

}

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

  //reviewId is auto-icrement in mysql, so no need to assign reviewId.
  public Review(int movieId, String authorProfile, String authorName, String review) {
    this.movieId = movieId;
    this.authorProfile = authorProfile;
    this.authorName = authorName;
    this.review = review;
  }

  public int getReviewId() {
    return reviewId;
  }

  public int getMovieId() {
    return movieId;
  }

  public String getAuthorProfile() {
    return authorProfile;
  }

  public String getAuthorName() {
    return authorName;
  }

  public String getReview() {
    return review;
  }

  @Override
  public String toString() {
    return "Review{" +
            "reviewId=" + reviewId +
            ", movieId=" + movieId +
            ", authorProfile='" + authorProfile + '\'' +
            ", authorName='" + authorName + '\'' +
            ", review='" + review + '\'' +
            '}';
  }
}

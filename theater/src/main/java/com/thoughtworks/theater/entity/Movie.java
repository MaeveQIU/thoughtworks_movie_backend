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

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getGenres() {
    return genres;
  }

  public void setGenres(String genres) {
    this.genres = genres;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public String getDirectors() {
    return directors;
  }

  public void setDirectors(String directors) {
    this.directors = directors;
  }

  public String getCasts() {
    return casts;
  }

  public void setCasts(String casts) {
    this.casts = casts;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getCountries() {
    return countries;
  }

  public void setCountries(String countries) {
    this.countries = countries;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "movieId=" + movieId +
            ", title='" + title + '\'' +
            ", year=" + year +
            ", genres='" + genres + '\'' +
            ", rating=" + rating +
            ", directors='" + directors + '\'' +
            ", casts='" + casts + '\'' +
            ", duration='" + duration + '\'' +
            ", image='" + image + '\'' +
            ", countries='" + countries + '\'' +
            ", tags='" + tags + '\'' +
            ", summary='" + summary + '\'' +
            '}';
  }
}

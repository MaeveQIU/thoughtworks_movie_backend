package com.thoughtworks.theater.repository;

import com.thoughtworks.theater.entity.Movie;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

  @Query("SELECT * FROM movie_basic WHERE title Like :title;")
  List<Movie> findByTitle(@Param("title") String title);


  @Modifying
  @Query("INSERT INTO movie_basic VALUES (:movieId, :title, :year, :genres, :rating, :directors, :casts, :duration," +
          ":image, :countries, :tags, :summary);")
  void post(@Param("movieId") Integer movieId,
            @Param("title") String title,
            @Param("year") Integer year,
            @Param("genres") String genres,
            @Param("rating") Double rating,
            @Param("directors") String directors,
            @Param("casts") String casts,
            @Param("duration") String duration,
            @Param("image") String image,
            @Param("countries") String countries,
            @Param("tags") String tags,
            @Param("summary") String summary);

}

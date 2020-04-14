package com.thoughtworks.theater;

import com.thoughtworks.theater.entity.Movie;
import com.thoughtworks.theater.entity.Review;
import com.thoughtworks.theater.repository.MovieRepository;
import com.thoughtworks.theater.repository.ReviewRepository;
import com.thoughtworks.theater.service.TheaterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TheaterApplicationTests {
	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ReviewRepository reviewRepo;

	@Test
	void findAllMTest() {
		List<Movie> movieList = (List<Movie>)movieRepo.findAll();
		for (Movie movie : movieList) {
			System.out.println(movie);
		}
	}

	@Test
	void findAllCommentsTest() {
		List<Review> reviewList = (List<Review>)reviewRepo.findAll();
		for (Review review : reviewList) {
			System.out.println(review);
		}
	}

	@Test
	void saveCommentTest() {
		Review review = new Review(111, "url", "xxx", "great movie");
		System.out.println(reviewRepo.save(review));
	}

	@Test
	void findByMovieNameTest() {
		List<Movie> movies = movieRepo.findByTitle("大鱼");
		for (Movie movie : movies) {
			System.out.println(movie);
		}
		System.out.println("===================");
		//like %?%
		List<Movie> moviesList = movieRepo.findByTitle("%2%");
		for (Movie movie : moviesList) {
			System.out.println(movie);
		}
	}

	@Test
	void findCommentsByMovieId() {
		List<Review> reviews = reviewRepo.findByMovieId(26942674);
		for (Review review : reviews) {
			System.out.println(review);
		}
	}

	@Autowired
	private TheaterService userService;

	@Test
	void serviceFindByMovieNameLike() {
		List<Movie> movies = userService.findByMovieNameLike("王");
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	@Test
	void serviceGetCommentsByMovieId() {
		List<Review> reviews = userService.getCommentsByMovieId(111);
		for (Review review : reviews) {
			System.out.println(review);
		}
	}
}

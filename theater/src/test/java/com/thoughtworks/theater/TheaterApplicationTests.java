package com.thoughtworks.theater;

import com.thoughtworks.theater.entity.Movie;
import com.thoughtworks.theater.entity.Review;
import com.thoughtworks.theater.repository.MovieRepository;
import com.thoughtworks.theater.repository.ReviewRepository;
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

}

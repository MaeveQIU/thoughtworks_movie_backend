package com.thoughtworks.theater;

import com.thoughtworks.theater.repository.MovieRepository;
import com.thoughtworks.theater.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TheaterApplicationTests {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ReviewRepository reviewRepo;

	@Test
	void contextLoads() {
	}

}

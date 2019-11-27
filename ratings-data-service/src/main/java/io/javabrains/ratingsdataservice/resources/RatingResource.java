package io.javabrains.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	
	@RequestMapping("/{movieID}")
	public Rating getRating(@PathVariable("movieID") String movieID) {
		
		
		return new Rating(movieID, 5);
	}
	
	
	@RequestMapping("users/{userID}")
public List<Rating> getRatings(@PathVariable("userID") String userID) {
		
		return Arrays.asList(new Rating("Titanic", 7), new Rating("4567", 9));
		
	}	
	

}

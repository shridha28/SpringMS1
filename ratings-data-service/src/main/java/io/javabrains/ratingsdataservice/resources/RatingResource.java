package io.javabrains.ratingsdataservice.resources;

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
	
	

}

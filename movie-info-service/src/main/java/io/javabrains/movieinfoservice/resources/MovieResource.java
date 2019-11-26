package io.javabrains.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.models.Movie;


@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	
	@RequestMapping("{movieID}")
	public Movie getInfo(@PathVariable("movieID") String movieID) {
		return new Movie(movieID, "Dangal");
	}

}

package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	//get all the movie rated IDs
	// for each movie get the movie info using movie info service
	//put all of them together
	
	
	@RequestMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable("userID") String userId){
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:8081/movies/5609", Movie.class);
		
		List<Rating>  ratings  = Arrays.asList(new Rating("Titanic", 7), new Rating("4567", 9));
		
		return ratings.stream().map(rating->new CatalogItem("Titanic", "desc", 7)).collect(Collectors.toList());
		
    //  return Collections.singletonList(new CatalogItem("Avatar", "Avatar", 5));		
	}
}

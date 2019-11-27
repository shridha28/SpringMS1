 package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.models.CatalogItem;
import io.javabrains.moviecatalogservice.models.Movie;
import io.javabrains.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	//get all the movie rated IDs
	// for each movie get the movie info using movie info service
	//put all of them together
	
	
	@RequestMapping("/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable("userID") String userId){
		
		List<Rating>  ratings  = Arrays.asList(new Rating("Titanic", 7), new Rating("4567", 9));
		
		return ratings.stream().map(rating->{
			Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieID(), Movie.class);
			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:8081/movies/"+rating.getMovieID()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
		return new CatalogItem(movie.getMovideId(), "desc", rating.getRating());})
				.collect(Collectors.toList());
		
    //  return Collections.singletonList(new CatalogItem("Avatar", "Avatar", 5));		
	}
}

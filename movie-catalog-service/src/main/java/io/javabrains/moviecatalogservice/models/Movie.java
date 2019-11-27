package io.javabrains.moviecatalogservice.models;

public class Movie {
	
	private String movideId;
	private String movieName;
	
	Movie(){}
	
	
	public String getMovideId() {
		return movideId;
	}
	public void setMovideId(String movideId) {
		this.movideId = movideId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Movie(String movideId, String movieName) {
		super();
		this.movideId = movideId;
		this.movieName = movieName;
	}
	

}

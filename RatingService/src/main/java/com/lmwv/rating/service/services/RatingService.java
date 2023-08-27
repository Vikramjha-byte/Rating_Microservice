package com.lmwv.rating.service.services;

import java.util.List;

import com.lmwv.rating.service.entities.Rating;

public interface RatingService {
	
	//save Rating
	
	Rating createRating(Rating rating);
	
	//get all Rating
	
	List<Rating> getAllRatings();
	
	
	// get all rating by hotel
	
	List<Rating> getRatingByHotelId(String hotelId);
	
	//get all rating by user
	
	List<Rating> getRatingByUserId(String userId);
	

}

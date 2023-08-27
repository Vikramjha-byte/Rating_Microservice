package com.lmwv.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmwv.rating.service.entities.Rating;
import com.lmwv.rating.service.repositories.RatingRepository;
import com.lmwv.rating.service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository repository;
	
	
	@Override
	public Rating createRating(Rating rating) {
		String RandomRating = UUID.randomUUID().toString();
		rating.setRatingId(RandomRating);
		return repository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return repository.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return repository.findByUserId(userId);
	}

}

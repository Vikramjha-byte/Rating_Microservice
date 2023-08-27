package com.lmwv.rating.service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lmwv.rating.service.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {

	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);
}

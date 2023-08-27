package com.lmwv.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmwv.rating.service.entities.Rating;
import com.lmwv.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

//save ratings

	@PostMapping("/save")
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
		Rating createRating = ratingService.createRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
	}

	// get all rating
	@GetMapping("/all")
	public ResponseEntity<List<Rating>> getAllRating() {
		List<Rating> allRatings = ratingService.getAllRatings();
		return ResponseEntity.ok(allRatings);
	}

	// get rating by hotel Id
	@GetMapping("hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> allRatings = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(allRatings);
	}

	// get rating by user Id
	@GetMapping("users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> allRatings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.ok(allRatings);
	}
}

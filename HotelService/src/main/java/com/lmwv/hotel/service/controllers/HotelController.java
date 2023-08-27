package com.lmwv.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmwv.hotel.service.entities.Hotel;
import com.lmwv.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	//save hotel
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel savedHotel = hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}
	
	//get all hotel
	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> listAllHotel(){
		List<Hotel> hotels = hotelService.getAllHotels();
		return ResponseEntity.ok(hotels);
	}
	
	
	//get hotel by id
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
		Hotel hotels = hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotels);
	}
}


package com.lmwv.hotel.service.services;

import java.util.List;

import com.lmwv.hotel.service.entities.Hotel;

public interface HotelService {

	//Save Hotel
		public Hotel saveHotel(Hotel hotel);
		
		//get hotel by ID
		
		public Hotel getHotelById(String hotelId);
		
		//getAll Hotels
		
		public List<Hotel> getAllHotels();
}

package com.lmwv.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmwv.hotel.service.entities.Hotel;
import com.lmwv.hotel.service.exceptions.ResourceNotFoundException;
import com.lmwv.hotel.service.repository.HotelRepository;
import com.lmwv.hotel.service.services.HotelService;



@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with the hotel id = <"+hotelId+">"));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}
}

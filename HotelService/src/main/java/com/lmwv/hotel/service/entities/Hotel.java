package com.lmwv.hotel.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hotel_micro_table")
public class Hotel {

	@Id
	@Column(name = "id")
	private String hotelId;
	@Column(name = "Name")
	private String name;
	@Column(name = "About")
	private String about;
	private String location;
}

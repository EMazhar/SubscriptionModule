package com.jp.submo.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_saved_addresses")
public class UserSavedAddress implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saved_address_id",updatable = false, nullable = false)
	private Long savedAddressId;
	
	//@NotNull
	@Column(name = "user_id")
	private long userId;
	
	@NotNull
	@Column(name = "address_name")
	private String addressName;
	
	
	@Column(name = "address_line_one")
	private String addressLineOne;
	
	
	@Column(name = "address_line_two")
	private String addressLineTwo;
	
	
	@Column(name = "address_line_three")
	private String addressLineThree;
	
	
	@Column(name = "user_location_lat")
	private double userLocationLat;
	
	@Column(name = "user_location_long")
	private double userLocationLong;

	@Override
	public String toString() {
		return "UserSavedAddress [savedAddressId=" + savedAddressId + ", userId=" + userId + ", addressName="
				+ addressName + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", addressLineThree=" + addressLineThree + ", userLocationLat=" + userLocationLat
				+ ", userLocationLong=" + userLocationLong + "]";
	}
	
	
	  
}

package com.jp.submo.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription_tariff")
public class SubscriptionTariff implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subscription_tariff_id")
	private long subscriptionTariffId;
	
	@Column(name="tariff_type")
	private String tariffType;
	
	@Column(name="duration_type")
	private String durationType;

	@Column(name="lookup_code")
	private String lookupCode;
	
	@Column(name="one_person")
	private double onePerson;
	
	@Column(name="two_person")
	private double twoPerson;
	
	@Column(name="three_person")
	private double threePerson;
	
	@Column(name="four_person")
	private double fourPerson;
	
	@Column(name="five_person")
	private double fivePerson;
	
	@Column(name="softdeleteflag")
	private byte softdeleteflag;
}

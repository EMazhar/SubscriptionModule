package com.jp.submo.repository.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chef_details")
public class ChefDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chef_id", nullable = false)
	private Long chefId;
	
	@NotEmpty
	@Column(name = "full_name")
	private String fullName;

	@Column(name = "chef_type")
	private Integer chefType;

	@Column(name = "chef_category")
	private Integer chefCategory;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "comments")
	private String comments;

	@Column(name = "availability_flag")
	private Byte isAvailable;

	@Column(name = "softdeleteflag")
	private Byte softdeleteflag;

	@Column(name="phone_number")
	private Long phoneNumber;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "chef_image")
	private String imageUrl;

	@Column(name = "service_range")
	private int serviceRange;

}

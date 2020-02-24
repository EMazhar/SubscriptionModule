package com.jp.submo.repository.entity;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity        
@Table(name = "all_dishes")
@NoArgsConstructor
public class AllDishes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dish_id",updatable = false, unique=true,nullable = false)
	private Long dishId;
	
	
	@Column(name = "dish_name")
	private String dishName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "dish_image")
	private String dishImage;
	
	@Column(name = "dish_video")
	private String dishVideo;
	
	@NotEmpty
	@Column(name = "dish_type")
	private Short dishType;
	
	@NotEmpty
	@Column(name = "dish_category")
	private Integer dishCategory;
		
}

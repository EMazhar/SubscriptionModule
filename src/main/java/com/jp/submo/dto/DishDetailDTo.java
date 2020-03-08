package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDetailDTo {
	
	private long dishId;
	private String dishName;
	private String discription;
	private String dishImage;
	private String dishCategory;

}

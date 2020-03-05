package com.jp.submo.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionMenuDto {

	private String mealType;
	private DishDetailDTo dishDetail;
}

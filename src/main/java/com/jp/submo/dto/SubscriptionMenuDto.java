package com.jp.submo.dto;

import java.util.List;

import com.jp.submo.repository.entity.AllDishes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionMenuDto {

	private long menuItemId;
	private int mealTypeId;
	private List<AllDishes> allDishes;
}

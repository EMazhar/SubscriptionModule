package com.jp.submo.dto;

import java.util.List;

import com.jp.submo.repository.entity.NewAllSubscription;
import com.jp.submo.repository.entity.NewSubscribedChef;
import com.jp.submo.repository.entity.NewSubscriptionMeal;
import com.jp.submo.repository.entity.NewSubscriptionPayment;
import com.jp.submo.repository.entity.SubscriptionCostNew;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class fetchSubsResponseDto {

	private List<NewAllSubscription> subscriptionList;
	private SubscriptionCostNew subscriptionCost;
	private NewSubscriptionPayment subscriptionPayment;
	private List<SubscriptionMealDto> subscriptionMealList;
	private List<NewSubscribedChefDto> subscribedChefList;
	
}

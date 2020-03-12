package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchSubsResponseDto {

	private long subscriptionId;
	private String status;
	private String assignedChef;
	private String startDate;
	private String endDate;
	
	//private String description;
	
	/*
	 * private List<NewAllSubscription> subscriptionList; private
	 * SubscriptionCostNew subscriptionCost; private NewSubscriptionPayment
	 * subscriptionPayment; private List<SubscriptionMealDto> subscriptionMealList;
	 * private List<NewSubscribedChefDto> subscribedChefList;
	 */
	
}

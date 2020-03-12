package com.jp.submo.dto;

import java.util.List;

import com.jp.submo.repository.entity.NewAllSubscription;
import com.jp.submo.repository.entity.NewSubscriptionPayment;
import com.jp.submo.repository.entity.SubscriptionCostNew;
import com.jp.submo.repository.entity.UserProfiles;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Data
@NoArgsConstructor
public class SubscriptionDetailResponseDto {
	
	private long subscriptionId;
	private String description;
	private long noOfPeople;
	private String startDate;
	private String endDate;
	//private long userId;
	private String subscriptionDeration;
	private String subscriptionStatus;
	private double longitude;
	private double latitude;
	private String subscriptionAddress;
	private UserProfiles userDetail;
	private SubscriptionCostNew subscriptionCost;
	private NewSubscriptionPaymentDto subscriptionPayment;
	private List<SubscriptionMealDto> subscribedMealList;
	private List<NewSubscribedChefDto> subscribedChefList;
}

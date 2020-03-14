package com.jp.submo.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefSubscriptionDto {
	private long subscriptionId;
	private Date startDate;
	private Date endDate;
	private String subscriptionStatus;
	private String chefFullName;
	private String subscriptionAddress;
	private String userFullName;
}

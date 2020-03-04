package com.jp.submo.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionActualDto {
	private Long subscriptionActualId;
	private long mealTypeId;
	 private long subscriptionId;
	 private Long actualStatusId;
	 private Long chefId;
	 private Timestamp date;
	 private Timestamp startTime;
	 private Timestamp endTime;
}

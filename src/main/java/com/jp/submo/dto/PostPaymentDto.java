package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Ehtesham
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPaymentDto {

	private long subscriptionId;
	private String razorOrderId;
	private int paymentStatus;
}

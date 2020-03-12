package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewSubscriptionPaymentDto {

	private long subPaymentId;
	private String paymentMode;
	private String paymentStatus;
	private String paymentTime;
	private String thirdPartyProvider;
	private double totalAmountPaid;
	private String transRefKey;
	private String transactionComment;
}

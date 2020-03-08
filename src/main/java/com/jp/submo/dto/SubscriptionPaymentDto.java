package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chetan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPaymentDto {

    private long paymentMode;

    private long thirdPartyProvider;
    
    private double totalAmountPaid;

    private String transactionComment;
    private String paymentStatus;
}

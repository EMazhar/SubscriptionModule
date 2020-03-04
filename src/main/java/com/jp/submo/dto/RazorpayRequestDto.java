package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RazorpayRequestDto {
	    private double amount;
	    private String currency;
	    private String receiptId;
	    private boolean payment_capture;
	    private String reason;
	
}

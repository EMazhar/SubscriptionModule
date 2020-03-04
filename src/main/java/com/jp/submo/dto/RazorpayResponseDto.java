package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RazorpayResponseDto {

	private String id;
	  private String entity;
	  private int amount;
	  private int amount_paid;
	  private int amount_due;
	  private String currency;
	  private String receipt;
	  private String status;
	  private int attempts;
	  private String [] notes;
	  private long created_at;
}

package com.jp.submo.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewSubscribedChefDto {
	private Long subscribedChefId;
	private long chefId;
	private Timestamp startDate;
	private Timestamp endDate;
	private String subscribedChefStatus;
}

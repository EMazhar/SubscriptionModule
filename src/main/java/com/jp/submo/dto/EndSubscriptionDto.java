package com.jp.submo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chetan,Ehtesham
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndSubscriptionDto {

    private long subscriptionId;
    private long actualStatusId;
    private long subscriptionStatusId;
    private String endType;
}

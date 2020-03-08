package com.jp.submo.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Ehtesham
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription_actuals")
public class SubscriptionActualNew implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_actual_id")
    private Long subscriptionActualId;


    @Column(name = "meal_type_id")
    private long mealTypeId;

    
    @Column(name = "subscription_id")
    private long subscriptionId;

    @Column(name = "actual_status_id")
    private long actualStatusId;

    @Column(name = "chef_id")
    private Long chefId;

    @Column(name="date")
    private Timestamp date;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

}
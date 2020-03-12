package com.jp.submo.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

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
@Table(name = "all_subscriptions")
@DynamicUpdate
public class NewAllSubscription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id", updatable = false, nullable = false)
    private Long subscriptionId;

    @Column(name = "description")
    private String description;
    @Column(name="number_of_people")
    private Long noOfPeople;
    
    @Column(name="longitude")
    private double longitude;
    
    @Column(name="latitude")
    private double latitude;
    
    @Column(name ="subscription_address")
    private String subscriptionAddress;

    @Column(name = "start_date")
    private Timestamp startDate;
    
    private Timestamp endDate;

	/*
	 * @Column(name = "user_id") private long userId;
	 */
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserProfiles userDetail;
    
    @Column(name="subscription_duration_id")
    private long subscriptionDurationId;

    @Column(name="subscription_status_id")
    private long subscriptionStatusId;

	/*
	 * @OneToMany(mappedBy = "subscription") private Collection<NewSubscribedChef>
	 * subscribedChefs;
	 */
}

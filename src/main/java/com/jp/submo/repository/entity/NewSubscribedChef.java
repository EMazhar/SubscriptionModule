package com.jp.submo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Ehtesham
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="subscribed_chefs")
@DynamicUpdate
public class NewSubscribedChef implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribed_chef_id")
    private Long subscribedChefId;

    @Column(name="subscription_id")
    private long subscriptionId;

    @Column(name = "chef_id")
    private long chefId;

    @Column(name="start_date")
    private Timestamp startDate;

    @Column(name="end_date")
    private Timestamp endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="subscribed_chef_status_id")
    private SubscribedChefStatus subscribedChefStatus;



}

package com.jp.submo.repository.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="subscription_payments")
@DynamicUpdate
public class NewSubscriptionPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sub_payment_id")
	private Long subPaymentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="payment_mode")
	private PaymentMode paymentMode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="payment_status")
	private PaymentStatus paymentStatus;

	@Column(name="payment_time")
	private Timestamp paymentTime;

	@Column(name="subscription_id")
	private long subscriptionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="third_party_provider")
	private ThirdPartyProvider thirdPartyProvider;

	@Column(name="total_amount_paid")
	private double totalAmountPaid;

	@Column(name="trans_ref_key")
	private String transRefKey;

	@Column(name="transaction_comment")
	private String transactionComment;

}

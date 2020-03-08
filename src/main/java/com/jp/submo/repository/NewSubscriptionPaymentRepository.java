
package com.jp.submo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.NewSubscriptionPayment;
import com.jp.submo.repository.entity.SubscriptionPayment;

/**
 * @author chetan
 */
@Repository
public interface NewSubscriptionPaymentRepository extends JpaRepository<NewSubscriptionPayment, Long> {
	NewSubscriptionPayment findBySubscriptionId(long subscriptionId);
}

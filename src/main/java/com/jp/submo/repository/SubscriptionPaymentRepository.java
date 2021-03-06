
package com.jp.submo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.SubscriptionPayment;

/**
 * @author chetan
 */
@Repository
public interface SubscriptionPaymentRepository extends JpaRepository<SubscriptionPayment, Long> {
	
	@Modifying
	@Query("UPDATE SubscriptionPayment sp SET  sp.transRefKey =?2,sp.paymentStatus.paymentStatusId=?3 WHERE sp.allSubscription.subscriptionId =?1")
	Integer updateSubscriptionPayment(long subscriptionId, String razorOrderId,long paymentStatus);
}

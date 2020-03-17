package com.jp.submo.repository;

import com.jp.submo.repository.entity.SubscriptionCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author chetan
 */
@Repository
public interface SubscriptionCostRepository extends JpaRepository<SubscriptionCost,Long> {
	
	/**
	 * 
	 * @param subscriptionId
	 * @return
	 */
	@Query("SELECT sc from SubscriptionCost as sc where sc.allSubscription.subscriptionId = ?1")
	SubscriptionCost findBySubscriptionId(long subscriptionId);


}

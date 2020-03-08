package com.jp.submo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.SubscriptionCostNew;

/**
 * @author chetan
 */
@Repository
public interface NewSubscriptionCostRepository extends JpaRepository<SubscriptionCostNew,Long> {

	SubscriptionCostNew findBySubscriptionId(long subscriptionId);

}

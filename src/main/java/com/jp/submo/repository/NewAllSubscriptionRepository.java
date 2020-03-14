package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.NewAllSubscription;

/**
 * @author chetan
 */
@Repository
public interface NewAllSubscriptionRepository extends JpaRepository<NewAllSubscription,Long> {

	
	@Query ("SELECT als from NewAllSubscription as als where als.userDetail.userId=?1")
	List<NewAllSubscription> findAllSubscription(long userId);
	
	List<NewAllSubscription> findAllBySubscriptionId(long subscriptionId);
	
	//@Query("SELECT als.subscriptionAddress,als.subscriptionId from NewAllSubscription as ")
	
	
}

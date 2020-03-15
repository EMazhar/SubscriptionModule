package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.AllSubscription;

/**
 * @author chetan,Ehtesham
 * 	
 */
@Repository
public interface AllSubscriptionRepository extends JpaRepository<AllSubscription,Long> {

	
	@Query ("SELECT als from AllSubscription as als where als.userProfile.userId=?1")
	List<AllSubscription> findAllSubscription(long userId);
	
	@Modifying
	@Query("update AllSubscription als set als.subscriptionStatus.subscriptionStatusId = ?2 where als.subscriptionId=?1")
	Integer updateSubscriptionStatus(long subscriptionId, long subscriptionStatus );
	
	
}

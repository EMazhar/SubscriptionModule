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

	
	@Query ("SELECT als from NewAllSubscription as als where als.userDetail.userId=?1 AND als.subscriptionStatusId=?2 AND als.softdeleteflag=0")
	List<NewAllSubscription> findAllSubscription(long userId,long subscriptionStatusId);
	
	List<NewAllSubscription> findAllBySubscriptionId(long subscriptionId);
	
	@Query("SELECT als from NewAllSubscription as als where als.subscriptionStatusId=?1 AND als.softdeleteflag=0")
	List<NewAllSubscription> findAllBySubscritpStatus(long subscriptionStatusId);
	
	//@Query("SELECT als.subscriptionAddress,als.subscriptionId from NewAllSubscription as ")
	
	
}

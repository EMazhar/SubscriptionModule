package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.dto.ChefSubscriptionDto;
import com.jp.submo.repository.entity.SubscribedChef;

/**
 * @author chetan
 */

@Repository
public interface SubscribedChefRepository extends JpaRepository<SubscribedChef, Long> {

	/**
	 * 
	 * @param chefId
	 * @return
	 * 
	 */	  
	  @Query(value = "SELECT new com.jp.submo.dto.ChefSubscriptionDto("
	  +" sc.subscription.subscriptionId," +" sc.startDate, sc.endDate,"
	  +" sc.subscribedChefStatus.description,"
	  +" sc.subscription.userProfile.fullName,"
	  +" sc.subscription.subscriptionAddress)"
	  +" FROM SubscribedChef as sc where sc.chefId=1 ",nativeQuery=true)
	List<ChefSubscriptionDto> findAllByChefId(long chefId);

}

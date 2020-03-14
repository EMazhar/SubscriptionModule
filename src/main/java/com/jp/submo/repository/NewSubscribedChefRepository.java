package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.dto.ChefSubscriptionDto;
import com.jp.submo.repository.entity.NewSubscribedChef;

/**
 * @author Ehtesham
 */

@Repository
public interface NewSubscribedChefRepository extends JpaRepository<NewSubscribedChef,Long> {
	
	List<NewSubscribedChef> findAllBySubscriptionId(long subscriptionId);
	
	/**
	 * 
	 * @param chefId
	 * @return
	 */
	
	@Query("SELECT new com.jp.submo.dto.ChefSubscriptionDto(sc.subscriptionId,sc.startDate,sc.endDate,sc.subscribedChefStatus.description,cp.fullName,als.subscriptionAddress,up.fullName)"
+ " from NewSubscribedChef as sc" 
+ " LEFT JOIN"
       + " ChefDetail as cp ON sc.chefId=cp.chefId"
+ " LEFT JOIN NewAllSubscription as als ON sc.subscriptionId = als.subscriptionId"

+ " LEFT JOIN UserProfiles as up ON als.userDetail.userId=up.userId"
+ " WHERE sc.chefId = ?1")
	List<ChefSubscriptionDto> findAllByChefId(long chefId);
	

}

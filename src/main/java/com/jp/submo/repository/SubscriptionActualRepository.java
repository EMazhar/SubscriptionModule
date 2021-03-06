package com.jp.submo.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.AllSubscription;
import com.jp.submo.repository.entity.MealType;
import com.jp.submo.repository.entity.SubscriptionActual;

/**
 * @author chetan,Ehtesham
 */

@Repository
public interface SubscriptionActualRepository extends JpaRepository<SubscriptionActual, Long> {
	SubscriptionActual findOneBySubscriptionAndMealTypeAndDateAndActualStatusId(AllSubscription allSubscription,
			MealType mealType, Timestamp date, Long actualStatusId);

	@Modifying
	@Query("Update SubscriptionActual sa SET sa.actualStatusId=:statusId WHERE sa.subscription.subscriptionId=:subscriptionId and sa.date > :today and sa.chefId=:chefId")
	void cancelSubscriptionActual(@Param("subscriptionId") long subcriptionId,@Param("statusId") Long statusId, @Param("chefId") Long chefId,
			@Param("today") Timestamp today);
	

}

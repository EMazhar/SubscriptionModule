package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.NewSubscriptionMeal;

/**
 * @author Ehtesham
 */
@Repository
public interface NewSubscriptionMealRepository extends JpaRepository<NewSubscriptionMeal,Long> {

	List<NewSubscriptionMeal> findAllBySubscriptionId(long subscriptionId);
}

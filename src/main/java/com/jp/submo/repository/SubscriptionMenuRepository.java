package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.SubscriptionMenu;

@Repository
public interface SubscriptionMenuRepository extends JpaRepository<SubscriptionMenu, Long> {
	/*
	 * @Query("SELECT sm from SubscriptionMenu sm" +
	 * "JOIN AllDishes ad ON sm.allDishes.dish_id=ad.dish_id")
	 */
	//List<SubscriptionMenu> getAllSubMenu();

}

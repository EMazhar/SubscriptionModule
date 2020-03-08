package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.NewSubscribedChef;

/**
 * @author Ehtesham
 */

@Repository
public interface NewSubscribedChefRepository extends JpaRepository<NewSubscribedChef,Long> {
	
	List<NewSubscribedChef> findAllBySubscriptionId(long subscriptionId);

}

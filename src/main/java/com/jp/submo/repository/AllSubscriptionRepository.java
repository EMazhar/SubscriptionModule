package com.jp.submo.repository;

import com.jp.submo.repository.entity.AllSubscription;
import com.jp.submo.repository.entity.UserProfiles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author chetan
 */
@Repository
public interface AllSubscriptionRepository extends JpaRepository<AllSubscription,Long> {

	
	@Query ("SELECT alls from AllSubscription as alls where alls.userProfile.userId=?1")
	List<AllSubscription> findAllSubscriptionByUserId(long userId);
	
}

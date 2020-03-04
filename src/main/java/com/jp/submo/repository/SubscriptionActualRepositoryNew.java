package com.jp.submo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.SubscriptionActual;
import com.jp.submo.repository.entity.SubscriptionActualNew;

/**
 * @author chetan
 */

@Repository
public interface SubscriptionActualRepositoryNew extends JpaRepository<SubscriptionActualNew, Long> {
      
    /**
     * 
     * @param chefId
     * @return
     * 
     */
    @Query("SELECT sa from SubscriptionActualNew sa where sa.subscriptionId=?1")
    List<SubscriptionActualNew> findAllBySubscriptionId(long subscriptionId);
}

package com.jp.submo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.SubscriptionTariff;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
@Repository
public interface SubscriptionTariffRepository extends JpaRepository<SubscriptionTariff, Long> {

}

package com.jp.submo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.submo.repository.entity.SubscriptionMenu;

@Repository
public interface SubscriptionMenuRepository extends JpaRepository<SubscriptionMenu, Long> {

}

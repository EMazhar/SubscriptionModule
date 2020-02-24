package com.jp.submo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.repository.AllSubscriptionRepository;
import com.jp.submo.repository.SubscriptionActualRepository;
import com.jp.submo.repository.SubscriptionMenuRepository;
import com.jp.submo.repository.SubscriptionTariffRepository;
import com.jp.submo.repository.entity.SubscriptionActual;
import com.jp.submo.repository.entity.SubscriptionMenu;
import com.jp.submo.repository.entity.SubscriptionTariff;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */

@Service
public class SubscriptionStaticServiceImpl implements SubscriptionStaticService {
	
	@Autowired
	private SubscriptionActualRepository subscriptionActualRepository;

	@Autowired
	private AllSubscriptionRepository allSubscriptionRepository;
	
	@Autowired
	private SubscriptionTariffRepository subscriptionTariffRepository;
	
	@Autowired
	private SubscriptionMenuRepository subscriptionMenuRepository;
	
	@Override
	public JpResponseModel fetchSubscriptionMenu() {
		List<SubscriptionMenu> subscriptionMenuList=subscriptionMenuRepository.findAll();
		return null;
	}

	@Override
	public JpResponseModel fetchsubscriptionTariff() {
		List<SubscriptionTariff> subsTariffList = subscriptionTariffRepository.findAll();
		return null;
	}

	@Override
	public JpResponseModel fetchSubscriptionByUser(long userId) {
		allSubscriptionRepository.findAllSubscriptionByUserId(userId);
		return null;
	}

	@Override
	public JpResponseModel fetchSubscriptionActualByUser(long userId) {
		// TODO Auto-generated method stub
		SubscriptionActual subscriptionActual = subscriptionActualRepository.findByChefId(userId);
		return null;
	}

	
}

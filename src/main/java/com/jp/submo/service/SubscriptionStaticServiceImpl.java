package com.jp.submo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.repository.AllSubscriptionRepository;
import com.jp.submo.repository.SubscriptionActualRepository;
import com.jp.submo.repository.SubscriptionMenuRepository;
import com.jp.submo.repository.SubscriptionTariffRepository;
import com.jp.submo.repository.entity.SubscriptionMenu;
import com.jp.submo.repository.entity.SubscriptionTariff;
import com.jp.submo.util.SubscriptionUtility;

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
		try {
			List<SubscriptionMenu> subscriptionMenuList=subscriptionMenuRepository.findAll();
			return SubscriptionUtility.success(subscriptionMenuList);
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error();
		}
	}

	@Override
	public JpResponseModel fetchsubscriptionTariff() {
		Map<String,Map<String,List<Double>>> responseMap = new HashMap<>();
		
		
		try {
			List<SubscriptionTariff> subsTariffList = subscriptionTariffRepository.findAll();
			
			List<Double> tariffwkList=new ArrayList<>();
			List<Double> tariffMonList=new ArrayList<>();
			Map<String,List<Double>> lookupWkMap = new HashMap<>();
			Map<String,List<Double>> lookupMonMap = new HashMap<>();
			
			for(SubscriptionTariff st: subsTariffList) {
				List<Double> tariffList=null;
				Map<String,List<Double>> lookupMap=null;
				if(st.getDurationType().equalsIgnoreCase("weekly")) {
					tariffList=new ArrayList<>();
					lookupMap=lookupWkMap;
				}else if(st.getDurationType().equalsIgnoreCase("monthly")) {
					tariffList=new ArrayList<>();
					lookupMap=lookupMonMap;
				}
				tariffList.add(st.getOnePerson());
				tariffList.add(st.getTwoPerson());
				tariffList.add(st.getThreePerson());
				tariffList.add(st.getFourPerson());
				tariffList.add(st.getFivePerson());
				lookupMap.put(st.getLookupCode(), tariffList);
				
			}
			responseMap.put("weekly",lookupWkMap);
			responseMap.put("monthly",lookupMonMap);
			
			return SubscriptionUtility.success(responseMap);
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error();
		}
		
	}

	@Override
	public JpResponseModel fetchSubscriptionByUser(long userId) {
		try {
		return SubscriptionUtility.success(allSubscriptionRepository.findAllSubscriptionByUserId(userId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error("Theres is no such user for user id :"+userId);
		}
	}

	@Override
	public JpResponseModel fetchSubscriptionActualByUser(long userId) {
		try {
			return SubscriptionUtility.success(subscriptionActualRepository.findByChefId(userId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error("Theres is no such user for user id :"+userId);
		}
	}
	
}

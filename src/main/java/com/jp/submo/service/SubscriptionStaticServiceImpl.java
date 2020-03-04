package com.jp.submo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.dto.SubscriptionActualDto;
import com.jp.submo.dto.SubscriptionMenuDto;
import com.jp.submo.repository.AllSubscriptionRepository;
import com.jp.submo.repository.SubscriptionActualRepository;
import com.jp.submo.repository.SubscriptionActualRepositoryNew;
import com.jp.submo.repository.SubscriptionMenuRepository;
import com.jp.submo.repository.SubscriptionTariffRepository;
import com.jp.submo.repository.entity.SubscriptionActual;
import com.jp.submo.repository.entity.SubscriptionActualNew;
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
	private SubscriptionActualRepositoryNew subscriptionActualRepositoryNew;

	@Autowired
	private AllSubscriptionRepository allSubscriptionRepository;
	
	@Autowired
	private SubscriptionTariffRepository subscriptionTariffRepository;
	
	@Autowired
	private SubscriptionMenuRepository subscriptionMenuRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	
	@Override
	public JpResponseModel fetchSubscriptionMenu() {
		List<SubscriptionMenuDto> subMenuDtoList = new ArrayList<>();
		try {
			List<SubscriptionMenu> subscriptionMenuList=subscriptionMenuRepository.findAll();
			for(SubscriptionMenu sm : subscriptionMenuList) {
				SubscriptionMenuDto subMenuDto = modelMapper.map(sm,SubscriptionMenuDto.class);
				//subMenuDto.setAllDishes(sm.getAllDishes());
				subMenuDtoList.add(subMenuDto);
			}
			
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
		return SubscriptionUtility.success(allSubscriptionRepository.findAllSubscription(userId));
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error("Theres is no such user for user id :"+userId);
		}
	}

	@Override
	public JpResponseModel fetchSubscriptionActualService(long subscriptionId) {
		List<SubscriptionActualDto> subDtoList = new ArrayList<>();;
		try {
			List<SubscriptionActualNew> response = subscriptionActualRepositoryNew.findAllBySubscriptionId(subscriptionId);
			for(SubscriptionActualNew subnew:response) {
				SubscriptionActualDto subDto= modelMapper.map(subnew,SubscriptionActualDto.class);
				//subDto.setMealType(subnew.getMealType());
						
				subDtoList.add(subDto);
				
			}
			return SubscriptionUtility.success(subDtoList);
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error("Theres is no such user for user id :"+subscriptionId);
		}
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
}

package com.jp.submo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.jp.submo.dto.DishDetailDTo;
import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.dto.NewSubscribedChefDto;
import com.jp.submo.dto.SubscriptionActualDto;
import com.jp.submo.dto.SubscriptionMealDto;
import com.jp.submo.dto.SubscriptionMenuDto;
import com.jp.submo.dto.SubscriptionPaymentDto;
import com.jp.submo.dto.fetchSubsResponseDto;
import com.jp.submo.repository.AllSubscriptionRepository;
import com.jp.submo.repository.NewAllSubscriptionRepository;
import com.jp.submo.repository.NewSubscribedChefRepository;
import com.jp.submo.repository.NewSubscriptionCostRepository;
import com.jp.submo.repository.NewSubscriptionMealRepository;
import com.jp.submo.repository.NewSubscriptionPaymentRepository;
import com.jp.submo.repository.SubscriptionActualRepository;
import com.jp.submo.repository.SubscriptionActualRepositoryNew;
import com.jp.submo.repository.SubscriptionCostRepository;
import com.jp.submo.repository.SubscriptionMenuRepository;
import com.jp.submo.repository.SubscriptionTariffRepository;
import com.jp.submo.repository.entity.AllDishes;
import com.jp.submo.repository.entity.NewAllSubscription;
import com.jp.submo.repository.entity.NewSubscribedChef;
import com.jp.submo.repository.entity.NewSubscriptionMeal;
import com.jp.submo.repository.entity.NewSubscriptionPayment;
import com.jp.submo.repository.entity.SubscriptionActual;
import com.jp.submo.repository.entity.SubscriptionActualNew;
import com.jp.submo.repository.entity.SubscriptionCostNew;
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
	
	private static final Map<Integer,String> dishCategoryMap=new HashMap<>();
	private static final Map<Integer,String> dishTypeMap=new HashMap<>();
	private static final Map<Integer,String> mealTypeMap=new HashMap<>();
	private static final Map<Integer,String> actualStatusMap=new HashMap<>();
	private static final Map<String,Map<String,List<Double>>> responseMap = new HashMap<>();
	private static Map<String,List<DishDetailDTo>> subMenuDtoMap=null;
	static
	{
		dishCategoryMap.put(1, "Starter");
		dishCategoryMap.put(2, "Main Course");
		dishCategoryMap.put(3,"Accompaniments");
		dishCategoryMap.put(4,"Dessert");
		dishTypeMap.put(1,"Vegetarian");
		dishTypeMap.put(2,"Non-Vegetarian");
		mealTypeMap.put(1, "Breakfast");
		mealTypeMap.put(2, "Lunch");
		mealTypeMap.put(3, "Dinner");
		
		actualStatusMap.put(1, "Dormant");actualStatusMap.put(2, "Active");actualStatusMap.put(3, "Completed");
		actualStatusMap.put(4, "Missed");actualStatusMap.put(5, "Re-assigned");actualStatusMap.put(6, "Cancelled by user");
		actualStatusMap.put(7, "Cancelled by chef");actualStatusMap.put(8, "Cancelled by jp");actualStatusMap.put(9, "Planned leave");
		actualStatusMap.put(10, "Holiday");actualStatusMap.put(11, "subscription inorganically ended");
	}
	
	@Autowired
	private SubscriptionActualRepositoryNew subscriptionActualRepositoryNew;

	@Autowired
	private AllSubscriptionRepository allSubscriptionRepository;
	
	@Autowired
	private NewAllSubscriptionRepository newAllSubscriptionRepository;
	
	@Autowired
	private SubscriptionTariffRepository subscriptionTariffRepository;
	
	@Autowired
	private SubscriptionMenuRepository subscriptionMenuRepository;
	
	@Autowired
	private NewSubscriptionCostRepository newSubscriptionCostRepository;
	
	@Autowired
	private NewSubscriptionPaymentRepository newSubscriptionPaymentRepository;
	
	@Autowired
	private NewSubscriptionMealRepository newSubscriptionMealRepository;
	
	@Autowired
	private NewSubscribedChefRepository newSubscribedChefRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	
	@Override
	public JpResponseModel fetchSubscriptionMenu() {
		if(subMenuDtoMap==null) {
			subMenuDtoMap = new HashMap<>();
		
		try {
			List<SubscriptionMenu> subscriptionMenuList=subscriptionMenuRepository.findAll();
			System.out.println("total menu size****"+subscriptionMenuList.size());
			List<DishDetailDTo> breakFastList= new ArrayList<>();
			List<DishDetailDTo> lunchList= new ArrayList<>();
			List<DishDetailDTo> dinnerList= new ArrayList<>();
			for(SubscriptionMenu sm : subscriptionMenuList) {
				//SubscriptionMenuDto subMenuDto = modelMapper.map(sm,SubscriptionMenuDto.class);
				//subMenuDto.setMealType(mealTypeMap.get(sm.getMealTypeId()));
				
				AllDishes ad=sm.getAllDishes();
				//subMenuDto.setDishDetail(new DishDetailDTo(ad.getDishId(),ad.getDishName(),ad.getDescription(),ad.getDishImage(),dishTypeMap.get(ad.getDishType()),dishCategoryMap.get(ad.getDishCategory())));
				
				switch(ad.getDishType()) {
				case 1:
					breakFastList.add(new DishDetailDTo(ad.getDishId(),ad.getDishName(),ad.getDescription(),ad.getDishImage(),dishCategoryMap.get(ad.getDishCategory())));
					break;
				case 2:
					lunchList.add(new DishDetailDTo(ad.getDishId(),ad.getDishName(),ad.getDescription(),ad.getDishImage(),dishCategoryMap.get(ad.getDishCategory())));
					break;
				case 3:
					dinnerList.add(new DishDetailDTo(ad.getDishId(),ad.getDishName(),ad.getDescription(),ad.getDishImage(),dishCategoryMap.get(ad.getDishCategory())));
					break;
				}
				
				subMenuDtoMap.put(mealTypeMap.get(1), breakFastList);
				subMenuDtoMap.put(mealTypeMap.get(2), lunchList);
				subMenuDtoMap.put(mealTypeMap.get(3), dinnerList);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error();
		}
		}
		return SubscriptionUtility.success(subMenuDtoMap);
	}

	@Override
	public JpResponseModel fetchsubscriptionTariff() {
		
		if(responseMap.isEmpty()) {
		
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
				if(st.getLookupCode()!=null) {
					lookupMap.put(st.getLookupCode(), tariffList);
				}
				
			}
			responseMap.put("weekly",lookupWkMap);
			responseMap.put("monthly",lookupMonMap);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error();
		}
		}
		return SubscriptionUtility.success(responseMap);
	}

	
	
	/**
	 * 
	 */
	@Override
	public JpResponseModel fetchSubscriptionByUser(long userId) {
		List<NewSubscribedChefDto> nscDtoList = new ArrayList<>();
		List<SubscriptionMealDto> smDtoList = new ArrayList<>();
		try {
			fetchSubsResponseDto responseDto = new fetchSubsResponseDto();
			List<NewAllSubscription> subscriptionList = newAllSubscriptionRepository.findAllSubscription(userId);
			long subscriptionId = subscriptionList.get(0).getSubscriptionId();
			SubscriptionCostNew subscriptionCost = newSubscriptionCostRepository.findBySubscriptionId(subscriptionList.get(0).getSubscriptionId());
			NewSubscriptionPayment subsPayment = newSubscriptionPaymentRepository.findBySubscriptionId(subscriptionId);
			
			List<NewSubscriptionMeal> subscriptionMealList = newSubscriptionMealRepository.findAllBySubscriptionId(subscriptionId);
			for(NewSubscriptionMeal nsm:subscriptionMealList) {
				SubscriptionMealDto smDto = new SubscriptionMealDto();
				smDto.setMealType(nsm.getMealType().getMealTypeId());
				smDto.setTime(nsm.getTime().toString());
				smDto.setMealTypeDscription(nsm.getMealType().getMealTypeDescription());
				smDtoList.add(smDto);
			}
			
			List<NewSubscribedChef> subscribedChefList = newSubscribedChefRepository.findAllBySubscriptionId(subscriptionId);
			for(NewSubscribedChef nsc:subscribedChefList) {
				NewSubscribedChefDto nscDto = modelMapper.map(nsc, NewSubscribedChefDto.class);
				nscDto.setSubscribedChefStatus(nsc.getSubscribedChefStatus().getDescription());
				nscDtoList.add(nscDto);
			}
			
			responseDto.setSubscriptionCost(subscriptionCost);
			responseDto.setSubscriptionList(subscriptionList);
			responseDto.setSubscriptionPayment(subsPayment);
			responseDto.setSubscriptionMealList(smDtoList);
			responseDto.setSubscribedChefList(nscDtoList);
			
			return SubscriptionUtility.success(responseDto);
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
				subDto.setMealType(mealTypeMap.get((int)subnew.getMealTypeId()));
				subDto.setActualStatus(actualStatusMap.get((int)subnew.getActualStatusId()));	
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

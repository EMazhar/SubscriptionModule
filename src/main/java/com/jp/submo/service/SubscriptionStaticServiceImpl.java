package com.jp.submo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.jp.submo.dto.ChefSubscriptionDto;
import com.jp.submo.dto.DishDetailDTo;
import com.jp.submo.dto.FetchSubsResponseDto;
import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.dto.NewSubscribedChefDto;
import com.jp.submo.dto.NewSubscriptionPaymentDto;
import com.jp.submo.dto.SubscriptionActualDto;
import com.jp.submo.dto.SubscriptionDetailResponseDto;
import com.jp.submo.dto.SubscriptionMealDto;
import com.jp.submo.repository.ChefDetailRepository;
import com.jp.submo.repository.NewAllSubscriptionRepository;
import com.jp.submo.repository.NewSubscribedChefRepository;
import com.jp.submo.repository.NewSubscriptionCostRepository;
import com.jp.submo.repository.NewSubscriptionMealRepository;
import com.jp.submo.repository.NewSubscriptionPaymentRepository;
import com.jp.submo.repository.SubscriptionActualRepositoryNew;
import com.jp.submo.repository.SubscriptionMenuRepository;
import com.jp.submo.repository.SubscriptionTariffRepository;
import com.jp.submo.repository.entity.AllDishes;
import com.jp.submo.repository.entity.ChefDetail;
import com.jp.submo.repository.entity.NewAllSubscription;
import com.jp.submo.repository.entity.NewSubscribedChef;
import com.jp.submo.repository.entity.NewSubscriptionMeal;
import com.jp.submo.repository.entity.NewSubscriptionPayment;
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
	private static final Map<Integer,String> SubcriptionStatusMap=new HashMap<>();
	private static final Map<Integer,String> SubcriptionDuratMap=new HashMap<>();
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
		
		SubcriptionStatusMap.put(1, "Prepayment");SubcriptionStatusMap.put(2, "Subscription Confirmed");
		SubcriptionStatusMap.put(3, "Chef Assigned");SubcriptionStatusMap.put(4, "Completed");
		SubcriptionStatusMap.put(5, "Inorganically Ended");

		SubcriptionDuratMap.put(1, "Weekly");SubcriptionDuratMap.put(2, "Monthly");
	
	}
	
	
	@Autowired
	private SubscriptionActualRepositoryNew subscriptionActualRepositoryNew;
	
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
	private ChefDetailRepository chefDetailRepository;
	
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
		String chefName = "";
		List<FetchSubsResponseDto> responseDtoList = new ArrayList<>();
		try {
		List<NewAllSubscription> subscriptionList = newAllSubscriptionRepository.findAllSubscription(userId);
		
		for(NewAllSubscription nas:subscriptionList) {
			Collection<NewSubscribedChef> subscribedChefs = newSubscribedChefRepository.findAllBySubscriptionId(nas.getSubscriptionId());
			List<NewSubscribedChef> subscribedChefList = new ArrayList(subscribedChefs);
			for(NewSubscribedChef sc:subscribedChefList) {
				if(sc.getSubscribedChefStatus().getDescription().equalsIgnoreCase("active")) {
					if(chefDetailRepository.existsById(sc.getChefId())) {
						chefName=chefDetailRepository.getOne(sc.getChefId()).getFullName();
						break;
					}
					
				}
			}
			
				
		responseDtoList.add(new FetchSubsResponseDto
				(nas.getSubscriptionId(),
						actualStatusMap.get((int)nas.getSubscriptionStatusId()), 
						chefName,
						nas.getStartDate().toString(),
						nas.getEndDate().toString()
						));
		chefName = "";
				 
		}
		return SubscriptionUtility.success(responseDtoList);
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
				SubscriptionActualDto subDto = modelMapper.map(subnew,SubscriptionActualDto.class);
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

	/**
	 * 
	 */
	@Override
	public JpResponseModel getSubscriptionDetail(long subscriptionId) {
		List<NewSubscribedChefDto> nscDtoList = new ArrayList<>();
		List<SubscriptionMealDto> smDtoList;
		
		try {
			SubscriptionDetailResponseDto responseDto = new SubscriptionDetailResponseDto();
			Optional<NewAllSubscription> subscriptionOption = newAllSubscriptionRepository.findById(subscriptionId);
			NewAllSubscription subscriptionDetails = subscriptionOption.get(); 
			//for(NewAllSubscription ns : subscriptionList) {
			responseDto=modelMapper.map(subscriptionDetails, SubscriptionDetailResponseDto.class);
			responseDto.setSubscriptionStatus(SubcriptionStatusMap.get((int)subscriptionDetails.getSubscriptionStatusId()));
			responseDto.setSubscriptionDeration(SubcriptionDuratMap.get((int)subscriptionDetails.getSubscriptionDurationId()));
			
			smDtoList=new ArrayList<>();
				/**
				 * bringing subscription cost on subscription Id
				 */
				SubscriptionCostNew subscriptionCost = newSubscriptionCostRepository.findBySubscriptionId(subscriptionId);
				responseDto.setSubscriptionCost(subscriptionCost);
				/**
				 * subscription payment on subscription id
				 */
				NewSubscriptionPayment subsPayment = newSubscriptionPaymentRepository.findBySubscriptionId(subscriptionId);
				responseDto.setSubscriptionPayment(new NewSubscriptionPaymentDto(subsPayment.getSubPaymentId(),
						subsPayment.getPaymentMode().getPaymentModeDescription(),
						subsPayment.getPaymentStatus().getPaymentStatusDescription(),
						subsPayment.getPaymentTime().toString(),
						subsPayment.getThirdPartyProvider().getThirdPartyProviderDescription(),
						subsPayment.getTotalAmountPaid(),
						subsPayment.getTransRefKey(),
						subsPayment.getTransactionComment()));
				/**
				 * subscribed meal on subscription id
				 */
				List<NewSubscriptionMeal> subscriptionMealList = newSubscriptionMealRepository.findAllBySubscriptionId(subscriptionId);
				for(NewSubscriptionMeal nsm:subscriptionMealList) {
					SubscriptionMealDto smDto = new SubscriptionMealDto();
					smDto.setTime(nsm.getTime().toString());
					smDto.setMealTypeDscription(nsm.getMealType().getMealTypeDescription());
					smDtoList.add(smDto);
				}
				responseDto.setSubscribedMealList(smDtoList);
				
				List<NewSubscribedChef> subscribedChefList = newSubscribedChefRepository.findAllBySubscriptionId(subscriptionId);
				for(NewSubscribedChef nsc:subscribedChefList) {
					NewSubscribedChefDto nscDto = new NewSubscribedChefDto();
					nscDto.setSubscribedChefStatus(nsc.getSubscribedChefStatus().getDescription());
					nscDto.setEndDate(nsc.getEndDate());
					nscDto.setStartDate(nsc.getEndDate());
					ChefDetail cd = chefDetailRepository.getOne(nsc.getChefId());
					if(cd !=null ) {
						nscDto.setChefName(cd.getFullName());
						nscDto.setChefImage(cd.getImageUrl());
					}
						
					nscDtoList.add(nscDto);
				}
				responseDto.setSubscribedChefList(nscDtoList);
			
			return SubscriptionUtility.success(responseDto);
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error("Theres is no such subscription for subscription id :"+subscriptionId);
		}

	}

	@Override
	public JpResponseModel getAllSubscriptionDetail() {
		List<SubscriptionDetailResponseDto> responseDtoList= new ArrayList<>();
		try {
		List<NewAllSubscription> subscriptionList = newAllSubscriptionRepository.findAll();
		for(NewAllSubscription nas:subscriptionList) {
			SubscriptionDetailResponseDto sdr = modelMapper.map(nas, SubscriptionDetailResponseDto.class);
			sdr.setSubscriptionStatus(SubcriptionStatusMap.get((int)nas.getSubscriptionStatusId()));
			sdr.setSubscriptionDeration(SubcriptionDuratMap.get((int)nas.getSubscriptionDurationId()));
			responseDtoList.add(sdr);
		}
		return SubscriptionUtility.success(responseDtoList);
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error();
		}
	}

	@Override
	public JpResponseModel getChefSubscriptionDetail(long chefId) {
		try {
			List<ChefSubscriptionDto>  scList=newSubscribedChefRepository.findAllByChefId(chefId);
	
			return SubscriptionUtility.success(scList);
		}catch(Exception ex) {
			ex.printStackTrace();
			return SubscriptionUtility.error("There is no subscription assigend to chef Id : "+chefId);
		}
	}
	
}

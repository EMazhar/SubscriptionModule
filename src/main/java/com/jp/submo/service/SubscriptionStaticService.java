package com.jp.submo.service;

import com.jp.submo.dto.JpResponseModel;

/**
 * 
 * @author EHTESHAM MAZHAR
 *
 */
public interface SubscriptionStaticService {
	
	/**
	 * 
	 * @return
	 */
	JpResponseModel fetchSubscriptionMenu();
	
	/**
	 * 
	 * @return
	 */
	JpResponseModel fetchsubscriptionTariff();
	
	/**
	 * 
	 * @return
	 */
	JpResponseModel fetchSubscriptionByUser(long userId);
	
	/**
	 * 
	 * @return
	 */
	JpResponseModel fetchSubscriptionActualService(long subscriptionId);
	
	/**
	 * 
	 * @param subscriptionId
	 * @return
	 */
	JpResponseModel getSubscriptionDetail(long subscriptionId);
	
	/**
	 * 
	 * @return
	 */
	JpResponseModel getAllSubscriptionDetail(String subscriptionStatus);
	
	/**
	 * 
	 * @param chefId
	 * @return
	 */
	JpResponseModel getChefSubscriptionDetail(long chefId);
}

package com.jp.submo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.dto.SubscriptionDto;
import com.jp.submo.service.SubscriptionStaticService;

@RestController
@CrossOrigin()
public class SubscriptionModuleSecondController {

	
	@Autowired
	private SubscriptionStaticService subscriptionStaticService;
	
	@GetMapping("/subscriptionActualByUser")
    public ResponseEntity<JpResponseModel> fetchSubscriptionActualByUser(@RequestBody() SubscriptionDto subscriptionDto) {
		return new ResponseEntity<>(subscriptionStaticService.fetchSubscriptionActualByUser(subscriptionDto.getUserId()),HttpStatus.OK);
		
	}

	@GetMapping("/subscription-menu")
    public ResponseEntity<JpResponseModel> fetchSubscriptionMenu() {
		return new ResponseEntity<>(subscriptionStaticService.fetchSubscriptionMenu(),HttpStatus.OK);
		
	}
	
	@GetMapping("/subscription-tariff")
    public ResponseEntity<JpResponseModel> fetchSubscriptionTariff() {
	    return new ResponseEntity<>(subscriptionStaticService.fetchsubscriptionTariff(),HttpStatus.OK);
		
	}
	
	@GetMapping("/subscriptionbyuser")
    public ResponseEntity<JpResponseModel> fetchSubscriptionByUser(@RequestBody SubscriptionDto subscriptionDto) {
		return new ResponseEntity<> (subscriptionStaticService.fetchSubscriptionByUser(subscriptionDto.getUserId()),HttpStatus.OK);
		
		
	}	

	
}

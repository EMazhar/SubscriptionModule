package com.jp.submo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/subscription-actuals")
    public ResponseEntity<JpResponseModel> fetchSubscriptionActual(@RequestBody() SubscriptionDto subscriptionDto) {
		return new ResponseEntity<>(subscriptionStaticService.fetchSubscriptionActualService(subscriptionDto.getSubscriptionId()),HttpStatus.OK);
		
	}

	@GetMapping("/subscription-menu")
    public ResponseEntity<JpResponseModel> fetchSubscriptionMenu() {
		return new ResponseEntity<>(subscriptionStaticService.fetchSubscriptionMenu(),HttpStatus.OK);
		
	}
	
	@GetMapping("/subscription-tariff")
    public ResponseEntity<JpResponseModel> fetchSubscriptionTariff() {
	    return new ResponseEntity<>(subscriptionStaticService.fetchsubscriptionTariff(),HttpStatus.OK);
		
	}
	
	@PostMapping("/user-subscription")
    public ResponseEntity<JpResponseModel> fetchSubscriptionByUser(@RequestBody SubscriptionDto subscriptionDto) {
		return new ResponseEntity<> (subscriptionStaticService.fetchSubscriptionByUser(subscriptionDto.getUserId()),HttpStatus.OK);
		
	}	
	
	@PostMapping("/subscription")
    public ResponseEntity<JpResponseModel> fetchSubscription(@RequestBody SubscriptionDto subscriptionDto) {
		return new ResponseEntity<> (subscriptionStaticService.getSubscriptionDetail(subscriptionDto.getSubscriptionId()),HttpStatus.OK);
		
	}	
	
	
	

	
}

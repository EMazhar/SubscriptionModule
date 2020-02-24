package com.jp.submo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/fetchSubscriptionActualByUser")
    public ResponseEntity<JpResponseModel> fetchSubscriptionActualByUser(@RequestBody() SubscriptionDto subscriptionDto) {
		return null;
	}

	@GetMapping("/fetchsubscription-menu")
    public ResponseEntity<JpResponseModel> fetchSubscriptionMenu(@RequestBody SubscriptionDto subscriptionDto) {
		return null;
	}
	
	@GetMapping("/fetchsubscriptionTariff")
    public ResponseEntity<JpResponseModel> fetchSubscriptionTariff(@RequestBody SubscriptionDto subscriptionDto) {
		return null;
	}
	
	@GetMapping("/fetchSubscriptionbyuser")
    public ResponseEntity<JpResponseModel> fetchSubscriptionByUser(@RequestBody SubscriptionDto subscriptionDto) {
		return null;
	}	

	
}

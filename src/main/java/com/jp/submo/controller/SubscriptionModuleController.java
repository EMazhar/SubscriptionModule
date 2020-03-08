package com.jp.submo.controller;

import com.jp.submo.dto.EndSubscriptionDto;
import com.jp.submo.dto.ReassignChefToSubscriptionDto;
import com.jp.submo.exception.SubscriptionException;
import com.jp.submo.dto.AssignChefToSubscriptionDto;
import com.jp.submo.dto.ConfirmSubscriptionDto;
import com.jp.submo.dto.CookingDto;
import com.jp.submo.dto.JpResponseModel;
import com.jp.submo.dto.PostPaymentDto;
import com.jp.submo.dto.SubscriptionDto;
import com.jp.submo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.jp.submo.util.SubscriptionUtility.error;

@RestController
@CrossOrigin()
public class SubscriptionModuleController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping(value = "/health")
    public ResponseEntity<String> getIngressHealth() {
        System.out.println("Hello , welcome to subscription Module.");
        return new ResponseEntity<String>("Hi, I am subscription Module. Up and running", HttpStatus.OK);
    }

    @PostMapping("/create-subscription")
    public ResponseEntity<JpResponseModel> createSubscription(@RequestBody() SubscriptionDto subscriptionDto) {
        try {
            return new ResponseEntity<>(subscriptionService.createSubscription(subscriptionDto, "test001"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/confirm-subscription")
    public ResponseEntity<JpResponseModel> confirmSubscription(@RequestBody() ConfirmSubscriptionDto
                                                                       confirmSubscriptionDto) {
        try {
            return new ResponseEntity<>(subscriptionService.confirmSubscription(confirmSubscriptionDto, "test002"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/assign-chef")
    public ResponseEntity<JpResponseModel> assignChefToSubscription(@RequestBody() AssignChefToSubscriptionDto
                                                                            assignChefToSubscriptionDto) {
        try {
            return new ResponseEntity<>(subscriptionService.assignChefToSubscription(assignChefToSubscriptionDto,
                    "test003"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/start-cooking")
    public ResponseEntity<JpResponseModel> startCooking(@RequestBody() CookingDto cookingDto) {
        try {
            return new ResponseEntity<>(subscriptionService.startCooking(cookingDto, "test005"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/end-cooking")
    public ResponseEntity<JpResponseModel> endCooking(@RequestBody() CookingDto cookingDto) {
        try {
            return new ResponseEntity<>(subscriptionService.endCooking(cookingDto, "test005"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/end-subscription")
    public ResponseEntity<JpResponseModel> endSubscription(@RequestBody() EndSubscriptionDto endSubscriptionDto) {
        try {
            return new ResponseEntity<>(subscriptionService.endSubscription(endSubscriptionDto, "test004", "test004"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/reassign-subscription")
    public ResponseEntity<JpResponseModel> reassignSubscriptionToChef(@RequestBody() ReassignChefToSubscriptionDto
                                                                                  reassignChefToSubscriptionDto) {
        try {
            return new ResponseEntity<>(subscriptionService.reassignChefToSubscription(reassignChefToSubscriptionDto,
                    "test004"),
                    HttpStatus.OK);
        } catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * this service is meant for post payment activity
     * @param postPaymentDto
     * @return
     */
    @PostMapping("/post-payment")
    public ResponseEntity<JpResponseModel> subscriptionPostPayment(@RequestBody PostPaymentDto postPaymentDto) {

    	try {
    	 return new ResponseEntity<>(subscriptionService.postPaymentActivity(postPaymentDto),
                 HttpStatus.OK);
    	 
    	} catch (SubscriptionException subExp) {
            return new ResponseEntity<>(error(subExp.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    	}catch(Exception ex) {
    		ex.printStackTrace();
    		return new ResponseEntity<>(error(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
}

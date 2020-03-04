package com.jp.submo.consumer;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.jp.submo.constant.AppConstant;
import com.jp.submo.dto.RazorpayRequestDto;
import com.jp.submo.dto.RazorpayResponseDto;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;



@Service
public class SubscriptionModuleConsumer {

	
	public String callRazorPayService (RazorpayRequestDto razorpayRequestDto) throws Exception {
		System.out.println("Hai re ");
		Order order=null;
		try {
		RazorpayClient razorpayClient = new RazorpayClient(AppConstant.RAZORPAY_ID,AppConstant.RAZORPAY_AUTH_TOKEN);
		JSONObject orderRequest = new JSONObject();
		System.out.println("Hai re ");
		orderRequest.put("amount", razorpayRequestDto.getAmount()*100);
		orderRequest.put("currency", "INR");
		orderRequest.put("receipt",razorpayRequestDto.getReceiptId());// razorpayRequestDto.getReceiptId());
		orderRequest.put("payment_capture", razorpayRequestDto.isPayment_capture());
		
			order = razorpayClient.Orders.create(orderRequest);
			System.out.println(order.toString());
		
		}catch(Exception ex) {
			System.out.print("Something went wrong");
			System.out.println();
			ex.printStackTrace();
		
			throw ex;
		}
		return order.get("id");
		
	}
	
	
}


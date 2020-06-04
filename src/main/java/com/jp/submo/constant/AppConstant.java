package com.jp.submo.constant;

/**
 * @author chetan
 */
public interface AppConstant {

    int SERVICE_RESPONSE_ON_SUCCESS = 1;
    int SERVICE_RESPONSE_ON_FAILED = 2;
    int FOUND = 1;
    int NOT_FOUND = 2;
    int EMAIL_CONFLICT = 3;
    int PHONE_NUMBER_CONFLICT = 4;
    int REGISTRATION_SUCCESSFUL = 5;
    int FAILED = 7;
    int EMAIL_LOGIN_MODE = 11;
    int PHONE_LOGIN_MODE = 12;

    String REQUEST_SUCCESSFUL = "The request was successfully served";
    String INTERNAL_ERROR = "Some internal error or requesting resource is not found";
    
    String RAZORPAY_AUTH_TOKEN="tlOzP7vC4OunSARSxNKdctPb";//U7Ra7zeUcCxjkuFpAWtGxfjG";
    String RAZORPAY_CREATE_ORDER_URL= "https://api.razorpay.com/v1/orders";
    String RAZORPAY_ID="rzp_live_MxTMMeiMCamZ6U";//"rzp_live_ykXz3EkZooRBfO";
    

}

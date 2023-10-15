package com.iamneo.service;

import com.razorpay.Order;
import com.razorpay.RazorpayException;

public interface OrderService {
   public Order createOrder(String amount, String currency) throws RazorpayException;
}

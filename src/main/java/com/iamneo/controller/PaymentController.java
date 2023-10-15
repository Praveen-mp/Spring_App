package com.iamneo.controller;

import com.iamneo.config.RazorpayConfig;
import com.iamneo.request.PaymentRequest;
import com.iamneo.response.PaymentResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayException;
@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private RazorpayConfig razorpayConfig;

    @PostMapping("/initiate")
    public ResponseEntity<PaymentResponse> initiatePayment(@RequestBody PaymentRequest paymentRequest) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient(razorpayConfig.getKey(), razorpayConfig.getKeySecret());
        JSONObject order = new JSONObject();
        if (paymentRequest.getAmount() < 100) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        order.put("amount", paymentRequest.getAmount()); // Amount in paise
        order.put("currency", "INR");
        order.put("receipt", "order_rcpt id_" + System.currentTimeMillis());
        order.put("payment_capture", 1); // Auto-capture

        try {
            Order razorpayOrder = razorpay.orders.create(order);
            PaymentResponse response = new PaymentResponse(razorpayOrder.get("id"), razorpayOrder.get("amount"));
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (RazorpayException e) {
            // Handle the exception or return an error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.iamneo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayConfig {
    @Value("${razorpay.key}")
    private String key;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    public String getKey() {
        return key;
    }

    public String getKeySecret() {
        return keySecret;
    }
}

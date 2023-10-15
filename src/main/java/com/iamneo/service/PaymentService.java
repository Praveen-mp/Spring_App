package com.iamneo.service;


import com.iamneo.dto.PaymentDto;
import com.iamneo.model.Payment;
import com.iamneo.response.UserResponse;

import java.util.List;

public interface PaymentService {
    public Payment getPaymentId(Long userId);
    public boolean deletePaymentId(Long user_id);
    boolean userRegistration(PaymentDto paymentDto);
}

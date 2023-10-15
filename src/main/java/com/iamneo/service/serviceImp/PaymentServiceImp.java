package com.iamneo.service.serviceImp;

import com.iamneo.dto.PaymentDto;
import com.iamneo.model.Payment;
import com.iamneo.service.PaymentService;

public class PaymentServiceImp implements PaymentService {

    @Override
    public Payment getPaymentId(Long userId) {
        return null;
    }

    @Override
    public boolean deletePaymentId(Long user_id) {
        return false;
    }

    @Override
    public boolean userRegistration(PaymentDto paymentDto) {
        return false;
    }
}

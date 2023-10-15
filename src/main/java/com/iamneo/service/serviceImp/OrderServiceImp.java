package com.iamneo.service.serviceImp;

import com.iamneo.service.OrderService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Transactional
@Service
public class OrderServiceImp implements OrderService {
    private static final String API_KEY = "rzp_test_14lbVISmQb6I1H";
    private static final String API_SECRET = "KSnZwBdMqbFlCzQBfhmT83NX";

    public Order createOrder(String amount, String currency) throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient(API_KEY, API_SECRET);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount); // Amount in paise
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", "order_rcptid_" + System.currentTimeMillis());
        orderRequest.put("payment_capture", 1); // Auto-capture
        // Add other order attributes as needed

        return razorpayClient.orders.create(orderRequest);
    }
}

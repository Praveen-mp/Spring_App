package com.iamneo.request;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.*;
import org.json.JSONObject;
@Data
@Getter
@Setter
@NoArgsConstructor
//@Builder
public class PaymentRequest {
    private int amount;
    private String currency;
    private String receipt;
    // Add other payment request fields as needed

//    public PaymentRequest(int amount, String currency, String receipt) {
//        this.amount = amount;
//        this.currency = currency;
//        this.receipt = receipt;
//    }

    public String createPaymentOrder() throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_14lbVISmQb6I1H", "KSnZwBdMqbFlCzQBfhmT83NX");
        JSONObject options = new JSONObject();
        options.put("amount", amount);
        options.put("currency", currency);
        options.put("receipt", receipt);

        return razorpayClient.orders.create(options).toString();
    }
}

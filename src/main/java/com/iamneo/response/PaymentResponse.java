package com.iamneo.response;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PaymentResponse {
    private String orderId;
    private Integer orderAmount; // Amount in paise

    // Add other fields as needed
}

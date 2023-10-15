package com.iamneo.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
    private Long paymentId;
    private String cardNumber;
    private String cardHolderName;
    private String totalFare;
}

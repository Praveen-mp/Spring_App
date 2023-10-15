package com.iamneo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "payment_list")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String cardNumber;
    private String cardHolderName;
    private String totalFare;
}

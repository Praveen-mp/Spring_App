package com.iamneo.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightFareDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAge;
    private String ticketType;
    private String mealsOption;
    private String wheelChair;
    private double totalFare;
}

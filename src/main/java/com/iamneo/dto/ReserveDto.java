package com.iamneo.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReserveDto {
    private Long bookingId;
    private String source;
    private String departureDate;
    private String destination;
    private String flightName;
}

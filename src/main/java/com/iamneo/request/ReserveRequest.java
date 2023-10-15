package com.iamneo.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReserveRequest {
    private String source;
    private String destination;
    private String departureDate;
    private String flightName;
}

package com.iamneo.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {
    private Long id;
    private String airline;
    private String source;
    private String destination;
    private String image;
}

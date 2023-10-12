package com.iamneo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "flight_details")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class FlightList{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String airline;
    private String source;
    private String destination;
    private String image;
}

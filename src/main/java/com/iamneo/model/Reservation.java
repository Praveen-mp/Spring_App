package com.iamneo.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "reserve_list")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String source;
    private String departureDate;
    private String destination;
    private String flightName;
}

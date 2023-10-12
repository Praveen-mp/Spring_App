package com.iamneo.repository;

import com.iamneo.model.FlightFare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightFareRepository extends JpaRepository<FlightFare,Long> {
    Optional<FlightFare> findByUserEmail(String userEmail);
}

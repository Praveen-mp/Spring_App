package com.iamneo.repository;

import com.iamneo.model.FlightList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<FlightList,Long> {
    @Override
    Optional<FlightList> findById(Long id);
}

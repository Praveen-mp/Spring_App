package com.iamneo.repository;

import com.iamneo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reservation,Long> {
    Optional<Reservation> findById(Long bookingId);
}

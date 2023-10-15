package com.iamneo.repository;

import com.iamneo.model.Payment;
import com.iamneo.model.Reservation;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @NotNull
    Optional<Payment> findById(@NotNull Long paymentId);
}

package com.iamneo.service;

import com.iamneo.dto.ReserveDto;
import com.iamneo.dto.UpdateUserDto;
import com.iamneo.dto.UserDto;
import com.iamneo.model.Reservation;

import java.util.Optional;

public interface ReserveService {
    public Optional<Reservation> findById(Long bookingId);
    boolean reserveAdd(ReserveDto reserveDto);
}

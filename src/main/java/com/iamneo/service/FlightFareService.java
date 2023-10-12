package com.iamneo.service;

import com.iamneo.dto.FlightFareDto;
import com.iamneo.dto.UserDto;
import com.iamneo.model.FlightFare;
import com.iamneo.model.User;
import org.springframework.beans.BeanUtils;

public interface FlightFareService {
    boolean saveUserFare(FlightFareDto dto);
    public FlightFare getUserById(Long userId);
    public FlightFare findByUserEmail(String userEmail);
}

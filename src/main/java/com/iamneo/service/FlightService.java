package com.iamneo.service;

import com.iamneo.dto.FlightDto;
import com.iamneo.model.FlightList;

import java.util.List;

public interface FlightService {
    List<FlightDto> getAllFlights();

    FlightList getById(Long id);
}

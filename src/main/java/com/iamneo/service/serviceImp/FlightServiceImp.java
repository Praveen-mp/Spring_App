package com.iamneo.service.serviceImp;

import com.iamneo.dto.FlightDto;
import com.iamneo.model.FlightList;
import com.iamneo.repository.FlightRepository;
import com.iamneo.service.FlightService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
public class FlightServiceImp implements FlightService {
    @Autowired
     private FlightRepository flightRepository;
    @Override
    public List<FlightDto> getAllFlights() {
        List<FlightList> flights = flightRepository.findAll();
        return flights.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlightList getById(Long id) {
        System.out.println(flightRepository.findById(id));
        return flightRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public boolean deleteFlight(Long id) {
        flightRepository.deleteById(id);
        return false;
    }


    private FlightDto convertToDTO(FlightList flight) {
         return FlightDto.builder()
                 .id(flight.getId())
                 .airline(flight.getAirline())
                 .source(flight.getSource())
                 .destination(flight.getDestination())
                 .image(flight.getImage())
                 .build();
    }
}

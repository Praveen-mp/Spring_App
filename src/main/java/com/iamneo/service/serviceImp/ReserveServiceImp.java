package com.iamneo.service.serviceImp;

import com.iamneo.dto.ReserveDto;
import com.iamneo.dto.UpdateUserDto;
import com.iamneo.model.FlightFare;
import com.iamneo.model.Reservation;
import com.iamneo.model.User;
import com.iamneo.repository.ReserveRepository;
import com.iamneo.service.ReserveService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Service
public class ReserveServiceImp implements ReserveService {

    @Autowired
    ReserveRepository reserveRepository;

    @Override
    public Optional<Reservation> findById(Long id) {
        return reserveRepository.findById(id);
    }

    @Override
    public boolean reserveAdd(ReserveDto reserveDto) {
        Optional<Reservation> isUserExists = reserveRepository.findById(reserveDto.getBookingId());
        if (isUserExists.isEmpty()) {
            System.out.println("Hello");
            var reservationBuilder = Reservation.builder()
                            .source(reserveDto.getSource())
                                    .destination(reserveDto.getDestination())
                    .departureDate(reserveDto.getDepartureDate())
                                            .flightName(reserveDto.getFlightName())
                                                    .build();
            reserveRepository.save(reservationBuilder);
            return true;
        } else {
            return false;
        }
    }


}

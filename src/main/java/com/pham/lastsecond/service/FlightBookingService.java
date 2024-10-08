package com.pham.lastsecond.service;

import com.pham.lastsecond.dto.FlightBookingDTO;
import com.pham.lastsecond.entity.FlightBooking;
import com.pham.lastsecond.entity.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pham.lastsecond.error.FlightBookingNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightBookingService {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    public void createFlightBooking(FlightBookingDTO flightBookingDTO) {
        FlightBooking flightBooking = mapDtoToEntity(flightBookingDTO);
        flightBookingRepository.save(flightBooking);
    }

    public FlightBookingDTO getFlightById(Long id) {
        Optional<FlightBooking> flightBooking = flightBookingRepository.findById(id);
        if (flightBooking.isPresent()) {
            return mapEntityToDto(flightBooking.get());
        } else {
            throw new FlightBookingNotFoundException("Booking not found with id: " + id);
        }
    }

    public List<FlightBookingDTO> getAllFlights() {
        return flightBookingRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public void updateFlightBooking(Long id, FlightBookingDTO flightBookingDTO) {
        if (!flightBookingRepository.existsById(id)) {
            throw new FlightBookingNotFoundException("Booking not found with id: " + id);
        }
        FlightBooking flightBooking = mapDtoToEntity(flightBookingDTO);
        flightBooking.setId(id);
        flightBookingRepository.save(flightBooking);
    }

    public void deleteFlightBooking(Long id) {
        flightBookingRepository.deleteById(id);
    }

    private FlightBookingDTO mapEntityToDto(FlightBooking flightBooking) {
        FlightBookingDTO dto = new FlightBookingDTO();
        dto.setFlightId(flightBooking.getId());
        dto.setCustomerFname(flightBooking.getCustomerFname());
        dto.setCustomerLname(flightBooking.getCustomerLname());
        dto.setCustomerId(flightBooking.getCustomerId());
        dto.setDepartAirport(flightBooking.getDepartAirport());
        dto.setDepartDate(flightBooking.getDepartDate());
        dto.setArrivalAirport(flightBooking.getArrivalAirport());
        dto.setArrivalDate(flightBooking.getArrivalDate());
        dto.setPrice(flightBooking.getPrice());
        return dto;
    }

    private FlightBooking mapDtoToEntity(FlightBookingDTO flightBookingDTO) {
        FlightBooking flightBooking = new FlightBooking();
        flightBooking.setId(flightBookingDTO.getFlightId());
        flightBooking.setCustomerFname(flightBookingDTO.getCustomerFname());
        flightBooking.setCustomerLname(flightBookingDTO.getCustomerLname());
        flightBooking.setCustomerId(flightBookingDTO.getCustomerId());  // Use Long
        flightBooking.setDepartAirport(flightBookingDTO.getDepartAirport());
        flightBooking.setDepartDate(flightBookingDTO.getDepartDate());
        flightBooking.setArrivalAirport(flightBookingDTO.getArrivalAirport());
        flightBooking.setArrivalDate(flightBookingDTO.getArrivalDate());
        flightBooking.setPrice(flightBookingDTO.getPrice());
        return flightBooking;
    }
}

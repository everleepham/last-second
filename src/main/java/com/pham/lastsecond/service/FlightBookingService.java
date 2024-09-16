package com.pham.lastsecond.service;

import com.pham.lastsecond.dto.FlightBookingDTO;
import org.springframework.stereotype.Service;
import com.pham.lastsecond.error.FlightBookingNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FlightBookingService {
    private final Map<Integer, FlightBookingDTO> bookings = new HashMap<>();

    public void creatFlightBooking(FlightBookingDTO flightBookingDTO) {
        bookings.put(flightBookingDTO.getFlightId(), flightBookingDTO);
    }

    public FlightBookingDTO getFlightById(Integer id) {
        return bookings.get(id);
    }

    public Map<Integer, FlightBookingDTO> getAllFlights() {
        return bookings;
    }

    public void updateFlight(FlightBookingDTO flightBookingDTO) {
        Integer id = flightBookingDTO.getFlightId();
        if (!bookings.containsKey(id)) {
            throw new FlightBookingNotFoundException("Booking not found with id: " + id);
        }
        bookings.put(id, flightBookingDTO);
    }

    public void deleteFlight(Integer id) {
        bookings.remove(id);
    }
}
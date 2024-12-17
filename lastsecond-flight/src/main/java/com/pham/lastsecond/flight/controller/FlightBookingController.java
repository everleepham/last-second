package com.pham.lastsecond.flight.controller;

import com.pham.lastsecond.flight.dto.FlightBookingDTO;
import com.pham.lastsecond.flight.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping
    public ResponseEntity<FlightBookingDTO> createFlightBooking(@RequestBody FlightBookingDTO flightBookingDTO) {
        flightBookingService.createFlightBooking(flightBookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightBookingDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightBookingDTO> getFlightBookingById(@PathVariable Long id) {
        FlightBookingDTO flightBookingDTO = flightBookingService.getFlightById(id);
        return ResponseEntity.ok(flightBookingDTO);
    }

    @GetMapping
    public ResponseEntity<List<FlightBookingDTO>> getAllFlightBookings() {
        List<FlightBookingDTO> allBookings = flightBookingService.getAllFlights();
        return ResponseEntity.ok(allBookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightBookingDTO> updateFlightBooking(@PathVariable Long id, @RequestBody FlightBookingDTO flightBookingDTO) {
        flightBookingService.updateFlightBooking(id, flightBookingDTO);
        return ResponseEntity.ok(flightBookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightBooking(@PathVariable Long id) {
        flightBookingService.deleteFlightBooking(id);
        return ResponseEntity.noContent().build();
    }
}
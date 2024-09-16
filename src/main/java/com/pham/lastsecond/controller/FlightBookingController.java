package com.pham.lastsecond.controller;

import com.pham.lastsecond.dto.FlightBookingDTO;
import com.pham.lastsecond.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/flights")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping
    public ResponseEntity<FlightBookingDTO> createFlightBooking(@RequestBody FlightBookingDTO flightBookingDTO) {
        flightBookingService.creatFlightBooking(flightBookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightBookingDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightBookingDTO> getFlightBookingById(@PathVariable Integer id) {
        FlightBookingDTO flightBookingDTO = flightBookingService.getFlightById(id);
        return ResponseEntity.ok(flightBookingDTO);
    }

    @GetMapping
    public ResponseEntity<Map<Integer, FlightBookingDTO>> getAllFlightBookings() {
        Map<Integer, FlightBookingDTO> allBookings = flightBookingService.getAllFlights();
        return ResponseEntity.ok(allBookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightBookingDTO> updateFlightBooking(@PathVariable Integer id, @RequestBody FlightBookingDTO flightBookingDTO) {
        flightBookingService.updateFlight(flightBookingDTO);
        return ResponseEntity.ok(flightBookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightBooking(@PathVariable Integer id) {
        flightBookingService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}








package com.pham.lastsecond.hotel.controller;

import com.pham.lastsecond.hotel.dto.HotelDTO;
import com.pham.lastsecond.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        HotelDTO hotelDTO = hotelService.getHotelById(id);
        return ResponseEntity.ok(hotelDTO);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> hotelDTOList = hotelService.getAllHotels();
        return ResponseEntity.ok(hotelDTOList);
    }

    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        hotelService.createHotelBooking(hotelDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO) {
        hotelService.updateHotelBooking(id, hotelDTO);
        return ResponseEntity.ok(hotelDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotelBooking(id);
        return ResponseEntity.noContent().build();
    }
}
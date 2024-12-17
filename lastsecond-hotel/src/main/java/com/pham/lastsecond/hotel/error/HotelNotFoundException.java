package com.pham.lastsecond.hotel.error; // Make sure this matches your package structure

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String message) {
        super(message);
    }
}
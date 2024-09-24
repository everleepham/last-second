package com.pham.lastsecond.error;

public class FlightBookingNotFoundException extends RuntimeException {
    public FlightBookingNotFoundException(String message) {
        super(message);
    }

}

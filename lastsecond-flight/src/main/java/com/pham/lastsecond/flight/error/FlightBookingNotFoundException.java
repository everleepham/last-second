package com.pham.lastsecond.flight.error;

public class FlightBookingNotFoundException extends RuntimeException {
    public FlightBookingNotFoundException(String message) {
        super(message);
    }

}

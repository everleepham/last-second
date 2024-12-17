package com.pham.lastsecond.service;


import com.pham.lastsecond.client.FlightBookingClient;
import com.pham.lastsecond.client.HotelBookingClient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripBookingService {
    private final FlightBookingClient flightBookingClient;
    private final HotelBookingClient hotelBookingClient;

    @Autowired
    public TripBookingService(FlightBookingClient flightBookingClient, HotelBookingClient hotelBookingClient) {
        this.flightBookingClient = flightBookingClient;
        this.hotelBookingClient = hotelBookingClient;
    }


    @Transactional
    public

}

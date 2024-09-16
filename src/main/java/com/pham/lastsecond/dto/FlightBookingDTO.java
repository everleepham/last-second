package com.pham.lastsecond.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightBookingDTO {
    private int flightId;
    private String customerFname;
    private String customerLname;
    private int customerId;
    private String departAirport;
    private LocalDateTime departDate;
    private String arrivalAirport;
    private LocalDateTime arrivalDate;
    private double price;
}

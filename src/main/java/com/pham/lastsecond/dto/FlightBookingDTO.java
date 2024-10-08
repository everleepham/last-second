package com.pham.lastsecond.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightBookingDTO {
    private Long flightId;
    private String customerFname;
    private String customerLname;
    private Long customerId;
    private String departAirport;
    private LocalDateTime departDate;
    private String arrivalAirport;
    private String arrivalDate;
    private Double price;
}


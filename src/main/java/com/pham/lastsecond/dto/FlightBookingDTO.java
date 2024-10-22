package com.pham.lastsecond.dto;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FlightBookingDTO {
    private Long flightId;
    private String customerFname;
    private String customerLname;
    private Long customerId;
    private String departAirport;
    private LocalDateTime departDate;
    private String arrivalAirport;
    private LocalDateTime arrivalDate;
    private Double price;
}


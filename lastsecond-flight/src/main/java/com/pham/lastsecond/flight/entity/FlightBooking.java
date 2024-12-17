package com.pham.lastsecond.flight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@ToString
@Table(name = "flight_booking")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long flightId;
    private String customerFname;
    private String customerLname;
    private Long customerId;
    private String departAirport;
    private LocalDateTime departDate;
    private String arrivalAirport;
    private LocalDateTime arrivalDate;
    private double price;

}
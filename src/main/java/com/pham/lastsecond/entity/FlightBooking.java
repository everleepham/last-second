package com.pham.lastsecond.entity;

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

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Changed to Long
    // Changed to Long
    private Long flightId;  // Changed to Long
    private String customerFname;
    private String customerLname;
    // Changed to Long
    // Changed to Long
    private Long customerId;  // Changed to Long
    private String departAirport;
    private LocalDateTime departDate;
    private String arrivalAirport;
    private LocalDateTime arrivalDate;
    private double price;

}
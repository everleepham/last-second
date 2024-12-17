package com.pham.lastsecond.hotel.entity;

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
@Table(name = "hotel_booking")

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long hotelId;
    private String customerFname;
    private String customerLname;
    private Long customerId;
    private String hotelName;
    private String hotelCity;
    private String hotelCountry;
    private String hotelPhone;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

}
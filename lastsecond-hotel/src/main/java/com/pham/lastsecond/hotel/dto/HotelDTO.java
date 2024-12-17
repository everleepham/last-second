package com.pham.lastsecond.hotel.dto;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class HotelDTO {
    private Long hotelId;
    private String customerFname;
    private String customerLname;
    private Long customerId;
    private String hotelName;
    private String hotelPhone;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

}

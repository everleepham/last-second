package com.pham.lastsecond.entity;

import com.pham.lastsecond.entity.FlightBooking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
    List<FlightBooking> findByFlightId(int flightId);
}

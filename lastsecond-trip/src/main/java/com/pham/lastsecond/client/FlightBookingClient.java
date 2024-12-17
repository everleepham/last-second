package com.pham.lastsecond.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import com.pham.lastsecond.dto.FlightBookingDTO;

public interface FlightBookingClient {

    @POST("flight/book")
    Call<Void> bookFlight(FlightBookingDTO flightBooking);

    @GET("flight/{id}")
    Call<FlightBookingDTO> getFlightById(@Path("id") Long flightId);

    @GET("flight")
    Call<List<FlightBookingDTO>> getAllFlights();
}

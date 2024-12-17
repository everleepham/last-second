package com.pham.lastsecond.trip.config;

import com.pham.lastsecond.trip.client.FlightBookingClient;
import com.pham.lastsecond.trip.client.HotelBookingClient;
import jdk.internal.access.JavaNetUriAccess;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitConfiguration {
    // Cấu hình OkHttpClient với các thiết lập cần thiết
    private OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)  // Thời gian chờ kết nối 1 phút
                .readTimeout(1, TimeUnit.MINUTES)     // Thời gian chờ đọc phản hồi 1 phút
                .writeTimeout(1, TimeUnit.MINUTES)    // Thời gian chờ ghi yêu cầu 1 phút
                .build();
    }

    @Bean
    public FlightBookingClient flightBookingClient() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8081")  // Địa chỉ URL của dịch vụ flight
            .client(okHttpClient())            // Sử dụng OkHttpClient với timeout
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        return retrofit.create(FlightBookingClient.class);
    }

    @Bean
    public HotelBookingClient hotelBookingClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8082")
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(HotelBookingClient.class);
    }
}


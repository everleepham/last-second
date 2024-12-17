package com.pham.lastsecond.hotel.service;

import com.pham.lastsecond.hotel.dto.HotelDTO;
import com.pham.lastsecond.hotel.entity.Hotel;
import com.pham.lastsecond.hotel.entity.HotelRepository;
import com.pham.lastsecond.hotel.error.HotelNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public void createHotelBooking(HotelDTO hotelDTO) {
        Hotel hotel = mapDtoToEntity(hotelDTO);
        hotelRepository.save(hotel);
    }

    public HotelDTO getHotelById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            return mapEntityToDto(hotel.get());
        } else {
            throw new HotelNotFoundException("Hotel not found with id: " + id);
        }
    }

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public void updateHotelBooking(Long id, HotelDTO hotelDTO) {
        if (!hotelRepository.existsById(id)) {
            throw new HotelNotFoundException("Hotel not found with id: " + id);
        }
        Hotel hotel = mapDtoToEntity(hotelDTO);
        hotel.setId(id); // Assuming there's a setId method in the Hotel entity
        hotelRepository.save(hotel);
    }

    public void deleteHotelBooking(Long id) {
        hotelRepository.deleteById(id);
    }

    private Hotel mapDtoToEntity(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(hotelDTO.getHotelId());
        hotel.setCustomerFname(hotelDTO.getCustomerFname());
        hotel.setCustomerLname(hotelDTO.getCustomerLname());
        hotel.setCustomerId(hotelDTO.getCustomerId());
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setHotelPhone(hotelDTO.getHotelPhone());
        hotel.setStartDate(hotelDTO.getStartDate());
        hotel.setEndDate(hotelDTO.getEndDate());
        hotel.setPrice(hotelDTO.getPrice());
        return hotel;
    }

    private HotelDTO mapEntityToDto(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setHotelId(hotel.getHotelId());
        dto.setCustomerFname(hotel.getCustomerFname());
        dto.setCustomerLname(hotel.getCustomerLname());
        dto.setCustomerId(hotel.getCustomerId());
        dto.setHotelName(hotel.getHotelName());
        dto.setHotelPhone(hotel.getHotelPhone());
        dto.setStartDate(hotel.getStartDate());
        dto.setEndDate(hotel.getEndDate());
        dto.setPrice(hotel.getPrice());
        return dto;
    }
}
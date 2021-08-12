package com.furkanguzel.eventdriven.api;

import com.furkanguzel.eventdriven.dto.HotelBookRequestDto;
import com.furkanguzel.eventdriven.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingApi {

    @Autowired
    private final ReservationService reservationService;

    public BookingApi(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void bookHotel(@RequestBody HotelBookRequestDto hotelBookRequestDto) throws InterruptedException {
        reservationService.publishReservationEvent(hotelBookRequestDto);
        System.out.println("User request processed." + hotelBookRequestDto);
    }
}

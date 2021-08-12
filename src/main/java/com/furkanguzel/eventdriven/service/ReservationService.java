package com.furkanguzel.eventdriven.service;

import com.furkanguzel.eventdriven.dto.HotelBookRequestDto;
import com.furkanguzel.eventdriven.event.ReservationCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ApplicationEventPublisher applicationeventPublisher;

    @Async
    public void publishReservationEvent(HotelBookRequestDto hotelBookRequestDto) throws InterruptedException {
        Thread.sleep(5000L);
        System.out.println("Reservation Service");
        applicationeventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequestDto));
    }

}

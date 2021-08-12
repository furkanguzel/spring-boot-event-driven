package com.furkanguzel.eventdriven.event.listener;

import com.furkanguzel.eventdriven.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) {
        try {
            Thread.sleep(5000L);
            System.out.println("Event Listener Handler");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("EventListener -> " + reservationCreatedEvent.getSource().toString());
    }
}

package com.sofrecom.droneboxtracker.shareddomain.events;


/**
 * Event Data for the DroneBox Routed Event
 */
public class DroneBoxRoutedEventData {

    private String bookingId;

    public DroneBoxRoutedEventData(String bookingId){ this.bookingId = bookingId; }

    public String getBookingId(){return this.bookingId;}

}

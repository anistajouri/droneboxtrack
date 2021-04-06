package com.sofrecom.droneboxtracker.shareddomain.events;



/**
 * Event Data for the DroneBox Booked Event
 */
public class DroneBoxBookedEventData {

    private String bookingId;

    public DroneBoxBookedEventData(){}
    public DroneBoxBookedEventData(String bookingId){ this.bookingId = bookingId; }
    public void setBookingId(String bookingId){this.bookingId = bookingId;}
    public String getBookingId(){return this.bookingId;}

}

package com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DroneBoxBookingId {
    @Column(name = "booking_id")
    private String bookingId;
    public DroneBoxBookingId(){}
    public DroneBoxBookingId(String bookingId){this.bookingId = bookingId;}
    public void setBookingId(String bookingId){this.bookingId = bookingId;}
    public String getBookingId(){return this.bookingId;}
}

package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto;

public class ChangeDestinationDto {

    private String bookingId;
    private String newDestLocation;

    public ChangeDestinationDto(String bookingId,String newDestLocation){
        this.setBookingId(bookingId);
        this.setNewDestLocation(newDestLocation);
    }

    public String getBookingId() { return bookingId; }

    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public String getNewDestLocation() { return newDestLocation; }

    public void setNewDestLocation(String newDestLocation) { this.newDestLocation = newDestLocation; }
}

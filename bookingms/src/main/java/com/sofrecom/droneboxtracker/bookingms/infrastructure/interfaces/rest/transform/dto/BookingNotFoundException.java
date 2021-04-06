package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto;

public class BookingNotFoundException  extends RuntimeException {
    public BookingNotFoundException(String bookingId) {
        super("No booking " + bookingId + " found", null, false, false);
    }
}


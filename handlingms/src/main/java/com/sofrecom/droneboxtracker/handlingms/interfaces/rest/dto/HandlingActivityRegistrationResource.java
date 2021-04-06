package com.sofrecom.droneboxtracker.handlingms.interfaces.rest.dto;

import java.time.LocalDate;

public class HandlingActivityRegistrationResource {

    private String bookingId;
    private String voyageNumber;
    private String locCode;
    private String handlingType;
    private LocalDate completionTime;

    public HandlingActivityRegistrationResource(){}

    public HandlingActivityRegistrationResource(String bookingId, String voyageNumber, String locCode, String handlingType, LocalDate completionTime){
        this.setBookingId(bookingId);
        this.setVoyageNumber(voyageNumber);
        this.setLocCode(locCode);
        this.setCompletionTime(completionTime);
    }


    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    public String getHandlingType() {
        return handlingType;
    }

    public void setHandlingType(String handlingType) {
        this.handlingType = handlingType;
    }

    public LocalDate getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(LocalDate completionTime) {
        this.completionTime = completionTime;
    }
}

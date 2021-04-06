package com.sofrecom.droneboxtracker.handlingms.domain.model.commands;


import java.util.Date;

/**
 * Command to Register an Handling Activity
 */
public class HandlingActivityRegistrationCommand {

    private Date completionTime;
    private String bookingId;
    private String voyageNumber;
    private String locCode;
    private String handlingType;

    public HandlingActivityRegistrationCommand(String bookingId, String voyageNumber, String locCode, String handlingType, Date completionTime){
        this.setCompletionTime(completionTime);
        this.setBookingId(bookingId);
        this.setVoyageNumber(voyageNumber);
        this.setLocCode(locCode);
        this.setHandlingType(handlingType);
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
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
}

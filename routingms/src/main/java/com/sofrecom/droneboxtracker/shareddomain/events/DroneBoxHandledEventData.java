package com.sofrecom.droneboxtracker.shareddomain.events;

import java.util.Date;

/**
 * Event Data for the DroneBox Handled Event
 */
public class DroneBoxHandledEventData {
    private String bookingId;
    private String handlingType;
    private Date handlingCompletionTime;
    private String handlingLocation;
    private String voyageNumber;

    public DroneBoxHandledEventData(){}

    public String getBookingId(){return this.bookingId;}
    public String getHandlingType(){return this.handlingType;}
    public Date getHandlingCompletionTime(){return this.handlingCompletionTime;}
    public String getHandlingLocation(){return this.handlingLocation;}
    public String getVoyageNumber(){return this.voyageNumber;}

    public void setBookingId(String bookingId){this.bookingId = bookingId;}
    public void setHandlingType(String handlingType){this.handlingType = handlingType;}
    public void setHandlingCompletionTime(Date handlingCompletionTime){this.handlingCompletionTime = handlingCompletionTime;}
    public void setHandlingLocation(String handlingLocation){this.handlingLocation = handlingLocation;}
    public void setVoyageNumber(String voyageNumber){this.voyageNumber = voyageNumber;}

}

package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;


import com.sofrecom.droneboxtracker.bookingms.domain.model.entities.Location;

/**
 * Route specification of the DroneBox - Origin/Destination and the Arrival Deadline
 */
public class RouteSpecification  {

    private Location origin;
    private Location destination;
  /*  private Date arrivalDeadline;*/


    public RouteSpecification(Location origin, Location destination/*,
                              Date arrivalDeadline*/) {
        this.setOrigin(origin);
        this.setDestination(destination);
        //this.setArrivalDeadline((Date) arrivalDeadline.clone());
    }


    public Location getOrigin() { return origin; }

    public void setOrigin(Location origin) { this.origin = origin; }

    public Location getDestination() { return destination; }

    public void setDestination(Location destination) { this.destination = destination; }
/*
    public Date getArrivalDeadline() { return arrivalDeadline; }

    public void setArrivalDeadline(Date arrivalDeadline) { this.arrivalDeadline = arrivalDeadline; }*/

}

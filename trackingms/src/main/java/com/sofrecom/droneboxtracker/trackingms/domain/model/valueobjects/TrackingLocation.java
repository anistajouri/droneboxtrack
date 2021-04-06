package com.sofrecom.droneboxtracker.trackingms.domain.model.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TrackingLocation class represented by a unique 5-diigit UN TrackingLocation code.
 */
@Embeddable
public class TrackingLocation {

    @Column(name = "location_id")
    private String locCode;
    public TrackingLocation(){}
    public TrackingLocation(String locCode){this.locCode = locCode;}
    public void setLocCode(String locCode){this.locCode = locCode;}
    public String getLocCode(){return this.locCode;}
}

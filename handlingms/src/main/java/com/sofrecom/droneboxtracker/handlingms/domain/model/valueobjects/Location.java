package com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Location class represented by a unique 5-diigit UN Location code.
 */
@Embeddable
public class Location {

    @Column(name = "location")
    private String locCode;
    public Location(){}
    public Location(String locCode){this.locCode = locCode;}
    public void setLocCode(String locCode){this.locCode = locCode;}
    public String getLocCode(){return this.locCode;}
}

package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *  Class representing the DroneBox Voyage
 */
@Embeddable
public class Voyage {

    @Column(name = "voyage_number", insertable = false, updatable = false)
    private String voyageNumber;

    public Voyage(){}

    public Voyage(String voyageId){
        this.voyageNumber = voyageNumber;
    }

    public String getVoyageId(){return this.voyageNumber;}

    public void setVoyageId(String voyageId){this.voyageNumber = voyageNumber;}
}

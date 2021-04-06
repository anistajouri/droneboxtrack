package com.sofrecom.droneboxtracker.routingms.domain.model.entities;


import com.sofrecom.droneboxtracker.routingms.domain.model.valueobjects.Location;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="drone_movement")
public class DroneMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name="arrival_date")
    private Date arrivalDate;
    @Temporal(TemporalType.DATE)
    @Column(name="departure_Date")
    private Date departureDate;
    @Embedded
    private Location arrivalLocation;
    @Embedded
    @AttributeOverride(name = "locCode", column = @Column(name = "departure_location_id"))
    private Location departureLocation;

    public DroneMovement(){}

    public DroneMovement(Location departureLocation,
                           Location arrivalLocation, Date departureDate, Date arrivalDate) {

        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public Location getArrivalLocation() {
        return arrivalLocation;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }


}

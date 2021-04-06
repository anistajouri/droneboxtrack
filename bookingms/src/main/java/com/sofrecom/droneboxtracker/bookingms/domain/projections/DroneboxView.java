package com.sofrecom.droneboxtracker.bookingms.domain.projections;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Projection class for the DroneBox Aggregate implemented as a regular JPA Entity. Contains a view of the DroneBox Aggregate
 */
@Entity
@Table(name="dronebox_view_projection")
@NamedQueries({ //Named Queries
        @NamedQuery(name = "DroneboxView.findAll",
                query = "Select c from DroneboxView c"),
        @NamedQuery(name = "DroneboxView.findByBookingId",
                query = "Select c from DroneboxView c where c.booking_id = :bookingId"),
        @NamedQuery(name = "DroneBox.getAllBookingIds",
                query = "Select c.booking_id from DroneboxView c") })
@Getter
@Setter
public class DroneboxView {

    @Id
    private String booking_id;

    private String transport_status;
    private String routing_status;
    private String spec_origin_id;
    private String spec_destination_id;


    public DroneboxView(){
        this.setBooking_id(null);
    }

    @JsonCreator
    public DroneboxView(@JsonProperty("booking_id") String booking_id,
                        @JsonProperty("transport_status") String transport_status,
                        @JsonProperty("routing_status") String routing_status,
                        @JsonProperty("spec_origin_id") String spec_origin_id,
                        @JsonProperty("spec_destination_id") String spec_destination_id/*,
                        Date deadline*/){
        this.setBooking_id(booking_id);
        this.setTransport_status(transport_status);
        this.setRouting_status(routing_status);
        this.setSpec_origin_id(spec_origin_id);
        this.setSpec_destination_id(spec_destination_id);
//        this.setDeadline(new Date());
    }
}

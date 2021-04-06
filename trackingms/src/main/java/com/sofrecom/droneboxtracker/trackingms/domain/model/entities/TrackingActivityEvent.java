package com.sofrecom.droneboxtracker.trackingms.domain.model.entities;


import com.sofrecom.droneboxtracker.trackingms.domain.model.valueobjects.TrackingEvent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TrackingActivityEvent {


    public static final TrackingActivityEvent EMPTY_ACTIVITY = new TrackingActivityEvent();

    @Column(name="tracking_events")
    private String trackingEvents;
/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_id")
    private List<TrackingEvent> trackingEvents = new ArrayList<TrackingEvent>();*/

    public TrackingActivityEvent() {
        // Nothing to initialize.
    }

    public TrackingActivityEvent(String trackingEvents) {
        this.trackingEvents = trackingEvents;
    }

    public void setTrackingActivityEvent(String trackingEvents) {
        this.trackingEvents = trackingEvents;
    }


    public String getTrackingEvents() {
        return trackingEvents;
    }

}

package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;


import java.util.Collections;
import java.util.List;


public class DroneBoxItinerary {

    public static final DroneBoxItinerary EMPTY_ITINERARY = new DroneBoxItinerary();

    private List<Route> routes = Collections.emptyList();

    public DroneBoxItinerary() {
        // Nothing to initialize.
    }

    public DroneBoxItinerary(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return Collections.unmodifiableList(routes);
    }
}

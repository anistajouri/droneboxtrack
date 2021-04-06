package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;

import java.util.Collections;
import java.util.List;

/**
 * Itinerary assigned to the DroneBox. Consists of a set of Routes that the DroneBox will go through as part of its journey
 */
public class Itinerary  {

    private List<Route> routes = Collections.emptyList();

    public Itinerary() {
        // Nothing to initialize.
    }

    public Itinerary(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return Collections.unmodifiableList(routes);
    }
}

package com.sofrecom.droneboxtracker.bookingms.domain.queries;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sofrecom.droneboxtracker.bookingms.domain.projections.DroneboxView;


/**
 * Implementation of the DroneBox View Result class which contains the results of the execution of the
 * DroneboxViewQuery. The result contains data from the DroneboxView Projection
 */
public class DroneboxViewResult {
    private DroneboxView droneboxView;

    @JsonCreator
    public DroneboxViewResult(@JsonProperty("DroneboxView") DroneboxView droneboxView) {
        this.droneboxView = droneboxView;
    }

    public DroneboxView getDroneboxView() {
        return droneboxView;
    }
}

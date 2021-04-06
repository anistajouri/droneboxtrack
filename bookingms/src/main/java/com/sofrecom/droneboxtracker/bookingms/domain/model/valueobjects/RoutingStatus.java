package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;

/**
 * Enum class for the Routing Status of the DroneBox
 */
public enum RoutingStatus {

    NOT_ROUTED, ROUTED, MISROUTED;

    public boolean sameValueAs(RoutingStatus other) {
        return this.equals(other);
    }
}
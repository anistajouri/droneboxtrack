package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;

/**
 * Enum class for the Transport Status of the DroneBox
 */
public enum TransportStatus {

    NOT_STARTED, IN_RELAY, ONBOARD_DRONE, ARRIVED, UNKNOWN;

    public boolean sameValueAs(TransportStatus other) {
        return this.equals(other);
    }
}

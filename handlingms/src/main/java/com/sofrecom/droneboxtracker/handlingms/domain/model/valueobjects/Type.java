package com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects;

/**
 * Handling event type. Either requires or prohibits a carrier movement
 * association, it's never optional.
 */
public enum Type {

    // Loaded onto voyage from port location.
    LOAD(true),
    // Unloaded from voyage to port location
    UNLOAD(true),
    // Received at relay point
    RECEIVED(false),
    // DroneBox arrived
    ARRIVED(false);
    private final boolean voyageRequired;

    /**
     * Private enum constructor.
     *
     * @param voyageRequired whether or not a voyage is associated with this
     * event type
     */
    private Type(boolean voyageRequired) {
        this.voyageRequired = voyageRequired;
    }

    /**
     * @return True if a voyage association is required for this event type.
     */
    public boolean requiresVoyage() {
        return voyageRequired;
    }

    /**
     * @return True if a voyage association is prohibited for this event
     * type.
     */
    public boolean prohibitsVoyage() {
        return !requiresVoyage();
    }

    public boolean sameValueAs(Type other) {
        return other != null && this.equals(other);
    }
}
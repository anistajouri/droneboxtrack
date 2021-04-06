package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto;

import java.text.SimpleDateFormat;

/**
 * Route Data Transfer Object
 */
public class Route {

    private static final SimpleDateFormat DATE_FORMAT
            = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");

    private final String voyageNumber;
    private final String fromLocCode;
    private final String toLocCode;
    private final String loadTime;
    private final String unloadTime;

    public Route(
            String voyageNumber,
            String fromLocCode,
            String toLocCode,
            String loadTime,
            String unloadTime) {
        this.voyageNumber = voyageNumber;
        this.fromLocCode = fromLocCode;
        this.toLocCode = toLocCode;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public String getFromLocCode() {
        return fromLocCode;
    }

    public String getToLocCode() {
        return toLocCode;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public String getUnloadTime() {
        return unloadTime;
    }


    @Override
    public String toString() {
        return "Route{" + "voyageNumber=" + voyageNumber + ", from=" + fromLocCode + ", to=" + toLocCode + ", loadTime=" + loadTime + ", unloadTime=" + unloadTime + '}';
    }
}

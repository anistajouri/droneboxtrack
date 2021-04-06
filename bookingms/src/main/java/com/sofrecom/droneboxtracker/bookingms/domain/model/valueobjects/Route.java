package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;

import com.sofrecom.droneboxtracker.bookingms.domain.model.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Route of the Itinerary that the DroneBox is currently on
 */
@Getter
@Setter
public class Route extends Itinerary {
    private static final SimpleDateFormat DATE_FORMAT
            = new SimpleDateFormat("MM/dd/yyyy hh:mm a z");

    private  String voyageNumber;
    private  String fromLocCode;
    private  String toLocCode;
    private  String loadTime;
    private  String unloadTime;

    private Voyage voyage;
    private Location loadLocation;
    private Location unloadLocation;
    private Date loadTimeDate;
    private Date unloadTimeDate;

    public Route(Voyage voyage, Location loadLocation,
               Location unloadLocation, Date loadTimeDate, Date unloadTimeDate){
        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadTimeDate = loadTimeDate;
        this.unloadTimeDate = unloadTimeDate;

    }

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


    @Override
    public String toString() {
        return "Route{" + "voyageNumber=" + voyageNumber + ", from=" + fromLocCode + ", to=" + toLocCode + ", loadTime=" + loadTime + ", unloadTime=" + unloadTime + '}';
    }
}

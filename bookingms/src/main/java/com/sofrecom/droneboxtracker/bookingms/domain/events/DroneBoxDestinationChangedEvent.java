package com.sofrecom.droneboxtracker.bookingms.domain.events;

import com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.RouteSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DroneBoxDestinationChangedEvent {
    private String bookingId;
    private RouteSpecification routeSpecification;
}

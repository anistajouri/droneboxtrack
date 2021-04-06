package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.tocommand;

import com.google.gson.Gson;
import com.sofrecom.droneboxtracker.bookingms.domain.commands.AssignRouteToDroneBoxCommand;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.Route;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.DroneBoxRouteDto;

import java.util.ArrayList;
import java.util.List;

public class AssignRouteCommandDTO {
    public static AssignRouteToDroneBoxCommand toCommandFromDTO(DroneBoxRouteDto droneboxRouteDto){

        List<com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.Route> routes = new ArrayList<>();

        for(Route route:
                droneboxRouteDto.getRoutes()){
            com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.Route routeDomainModel = new com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.Route(route.getVoyageNumber(),
                    route.getFromLocCode(),
                    route.getToLocCode(),
                    route.getLoadTime(),
                    route.getUnloadTime());

            routes.add(routeDomainModel);

        }
        Gson gson = new Gson();;
        return new AssignRouteToDroneBoxCommand(droneboxRouteDto.getBookingId(),gson.toJson(routes));
    }
}

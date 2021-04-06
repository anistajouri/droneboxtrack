package com.sofrecom.droneboxtracker.bookingms.application.acl;


import com.google.gson.Gson;
import com.sofrecom.droneboxtracker.bookingms.domain.model.entities.Location;
import com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.DroneBoxItinerary;
import com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.Route;
import com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects.Voyage;
import com.sofrecom.droneboxtracker.bookingms.domain.shareddomain.RelaypointEdge;
import com.sofrecom.droneboxtracker.bookingms.domain.shareddomain.RelaypointPath;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Anti Corruption Service Class from BOOKING ms to ROUTING ms
 */

@Slf4j
@Service
public class ExternalDroneBoxRoutingService {

    /**
     * External call to the ROUTING microservice :
     * it fetch the Optimal Itinerary for a DroneBox based on the Route Specification
     * @param routeSpecification
     * @return
     */
    public DroneBoxItinerary fetchRouteForSpecification(String routeSpecification){

        RestTemplate restTemplate = new RestTemplate();
        Map<String,Object> params = new HashMap<>();

        String[] loc = routeSpecification.split("-");

        params.put("origin",loc[0]);
        params.put("destination",loc[1]);
        params.put("deadline","2020-10-28");

        RelaypointPath relaypointPath = restTemplate.getForObject("http://localhost:8083/droneboxrouting/optimalRoute?origin=&destination=&deadline=",
                    RelaypointPath.class);


        List<Route> routes = new ArrayList<>(relaypointPath.getRelaypointEdges().size());
        for (RelaypointEdge edge : relaypointPath.getRelaypointEdges()) {
            routes.add(toRoute(edge));
        }

        return new DroneBoxItinerary(routes);

    }

    /**
     * Makes a call to the Routing Service to get the corresponding routes for a route
     * @return
     */
    public String getItinaryForSpecification(String routeSpecification){
        // create a new Gson instance
        Gson gson = new Gson();

        DroneBoxItinerary itinerary = fetchRouteForSpecification(routeSpecification);
        String displayedItinary = "";

        String jsonRoutes = gson.toJson(itinerary.getRoutes());
        log.info("jsonRoutes= {}",jsonRoutes);

        for (Route route : itinerary.getRoutes()) {
            displayedItinary += "From "+ route.getUnloadLocation().getLocCode() +" at " + route.getUnloadTimeDate() + " --> ";
            displayedItinary += route.getLoadLocation().getLocCode()  + " at " + route.getLoadTimeDate() + " / ";
        }
        log.info("displayedItinary= {}", displayedItinary);

        return displayedItinary;
    }

    /**
     * Anti-corruption layer CONVERSION method :
     *      from --> the ROUTING microservice domain model (Relaypoint Edges)
     *      to --> domain model recognized by the BOOKING microservice (Routes)
     * @param edge
     * @return
     */
    private Route toRoute(RelaypointEdge edge) {
        return new Route(
                new Voyage(edge.getVoyageNumber()),
                new Location(edge.getFromLocCode()),
                new Location(edge.getToLocCode()),
                edge.getFromDate(),
                edge.getToDate());
    }
}

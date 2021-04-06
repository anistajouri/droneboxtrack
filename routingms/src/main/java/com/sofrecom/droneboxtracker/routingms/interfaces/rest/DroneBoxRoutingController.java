package com.sofrecom.droneboxtracker.routingms.interfaces.rest;


import com.sofrecom.droneboxtracker.routingms.application.internal.queryservices.DroneBoxRoutingQueryService;
import com.sofrecom.droneboxtracker.routingms.domain.model.aggregates.Voyage;
import com.sofrecom.droneboxtracker.routingms.domain.model.entities.DroneMovement;
import com.sofrecom.droneboxtracker.shareddomain.model.RelaypointEdge;
import com.sofrecom.droneboxtracker.shareddomain.model.RelaypointPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping("/droneboxrouting")
public class DroneBoxRoutingController {


    private DroneBoxRoutingQueryService droneboxRoutingQueryService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param droneboxRoutingQueryService
     */
    public DroneBoxRoutingController(DroneBoxRoutingQueryService droneboxRoutingQueryService){
        this.droneboxRoutingQueryService = droneboxRoutingQueryService;
    }


    /**
     *
     * @param originLocCode
     * @param destinationLocCode
     * @param deadline
     * @return RelaypointPath - The optimal route for a Route Specification
     */

    @GetMapping(path = "/optimalRoute")
    @ResponseBody
    public RelaypointPath findOptimalRoute(
             @RequestParam("origin") String originLocCode,
             @RequestParam("destination") String destinationLocCode,
             @RequestParam("deadline") String deadline) {

        List<Voyage> voyages = droneboxRoutingQueryService.findAll();
        RelaypointPath relaypointPath = new RelaypointPath();
        List<RelaypointEdge> relaypointEdges = new ArrayList<>();
        for(Voyage voyage:voyages){

            RelaypointEdge relaypointEdge = new RelaypointEdge();
            relaypointEdge.setVoyageNumber(voyage.getVoyageNumber().getVoyageNumber());
            DroneMovement movement =
                    ((List<DroneMovement>)voyage.getSchedule().getDroneMovements()).get(0);
            relaypointEdge.setFromDate(movement.getArrivalDate());
            relaypointEdge.setToDate(movement.getDepartureDate());
            relaypointEdge.setFromLocCode(movement.getArrivalLocation().getLocCode());
            relaypointEdge.setToLocCode(movement.getDepartureLocation().getLocCode());
            relaypointEdges.add(relaypointEdge);

        }

        relaypointPath.setRelaypointEdges(relaypointEdges);
        return relaypointPath;

    }
}

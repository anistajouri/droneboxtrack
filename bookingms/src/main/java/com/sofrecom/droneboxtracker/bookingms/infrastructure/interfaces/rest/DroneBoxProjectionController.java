package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest;


import com.sofrecom.droneboxtracker.bookingms.application.queries.DroneBoxProjectionService;
import com.sofrecom.droneboxtracker.bookingms.domain.queries.DroneboxViewResult;
import org.springframework.web.bind.annotation.*;

/**
 * REST API for all operations related to the DroneBox Aggregate Projections
 */
@RestController
@RequestMapping("/droneboxview")
public class DroneBoxProjectionController {


    private DroneBoxProjectionService droneboxProjectionService;
    public DroneBoxProjectionController(DroneBoxProjectionService droneboxProjectionService){
        this.droneboxProjectionService = droneboxProjectionService;
    }

    @GetMapping("/{bookingid}")
    public DroneboxViewResult droneboxView(@PathVariable(value = "bookingid") String bookingId){
       // commandGateway.send(BookDroneBoxCommandDTOAssembler.toCommandFromDTO(bookDroneBoxCommandDto));
        DroneboxViewResult droneboxView = droneboxProjectionService.queryDroneboxView(bookingId);
        return droneboxView;
    }



}

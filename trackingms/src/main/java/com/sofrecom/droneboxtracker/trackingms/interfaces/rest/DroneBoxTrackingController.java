package com.sofrecom.droneboxtracker.trackingms.interfaces.rest;

import com.sofrecom.droneboxtracker.trackingms.application.queryservices.DroneBoxTrackingQueryService;
import com.sofrecom.droneboxtracker.trackingms.domain.model.aggregates.TrackingActivity;
import com.sofrecom.droneboxtracker.trackingms.domain.model.entities.BookingId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // This means that this class is a Controller
@RequestMapping("/droneboxtracking")
public class DroneBoxTrackingController {

    private DroneBoxTrackingQueryService droneboxTrackingQueryService;

    /**
     * Provide the dependencies
     * @param droneboxTrackingQueryService
     */
    public DroneBoxTrackingController(DroneBoxTrackingQueryService droneboxTrackingQueryService){
        this.droneboxTrackingQueryService = droneboxTrackingQueryService;
    }



    /**
     * GET method to retrieve a DroneBox
     * @param bookingId
     * @return
     */
    @GetMapping("/{bookingid}")
    public String findByBookingId(@PathVariable(value = "bookingid") String bookingId){
        TrackingActivity trackingActivity = droneboxTrackingQueryService.find(new BookingId(bookingId));
        return trackingActivity.getTrackingActivityEvents().getTrackingEvents();
    }


    /**
     * GET method to retrieve a DroneBox
     * @return
     */
    @GetMapping("/all")
    public List<TrackingActivity> findAll(){
        return droneboxTrackingQueryService.findAll();
    }
}


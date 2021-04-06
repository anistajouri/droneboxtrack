package com.sofrecom.droneboxtracker.trackingms.application.queryservices;

import com.sofrecom.droneboxtracker.trackingms.domain.model.aggregates.TrackingActivity;
import com.sofrecom.droneboxtracker.trackingms.domain.model.entities.BookingId;
import com.sofrecom.droneboxtracker.trackingms.infrastructure.repositories.jpa.TrackingActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Application Service which caters to all queries related to the Booking Bounded Context
 */
@Slf4j
@Service
public class DroneBoxTrackingQueryService {

    @Autowired
    TrackingActivityRepository trackingActivityRepository; // Inject Dependencies

    /**
     * Find all DroneBoxs
     * @return List<TrackingActivity>
     */

    public List<TrackingActivity> findAll(){
        return trackingActivityRepository.findAll();
    }

    /**
     * List All Booking Identifiers
     * @return List<BookingId>
     */
  /*  public List<TrackingActivity> findAllBookingIds(){

        return trackingRepository.findAllTrackingNos();
    }*/

    /**
     * Find a specific DroneBox based on its Booking Id
     * @param bookingId
     * @return DroneBox
     */
    public TrackingActivity find(BookingId bookingId){
        TrackingActivity trackingActivity = trackingActivityRepository.findByBookingId(bookingId);
        log.info("trackingactivity = {} {}", trackingActivity.getBookingId().getBookingId(), trackingActivity.getTrackingActivityEvents().getTrackingEvents());
        return trackingActivity;
    }
}

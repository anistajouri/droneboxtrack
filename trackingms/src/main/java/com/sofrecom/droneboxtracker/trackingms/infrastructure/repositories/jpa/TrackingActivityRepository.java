package com.sofrecom.droneboxtracker.trackingms.infrastructure.repositories.jpa;


import com.sofrecom.droneboxtracker.trackingms.domain.model.aggregates.TrackingActivity;
import com.sofrecom.droneboxtracker.trackingms.domain.model.valueobjects.TrackingNumber;
import com.sofrecom.droneboxtracker.trackingms.domain.model.entities.BookingId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository class for the Tracking Aggregate. Deals with all repository operations
 * related to the state of the Tracking of the DroneBox
 */
public interface TrackingActivityRepository extends JpaRepository<TrackingActivity,Long> {
    /**
     * Returns the DroneBox Aggregate based on the Tracking Number of the DroneBox
     * @param trackingNumber
     * @return TrackingActivity
     */
    public TrackingActivity findByTrackingNumber(TrackingNumber trackingNumber);
    /**
     * Returns the Tracking Aggregate based on the Booking Identifier
     * @param bookingId
     * @return
     */
    public TrackingActivity findByBookingId(BookingId bookingId);


    /**
     * Find all Tracking Activity Aggregates
     * @return
     */
    public List<TrackingActivity> findAll();


    /**
     * Find all Tracking Numbers
     * @return
     */
    public List<TrackingNumber> findAllTrackingNos();

}

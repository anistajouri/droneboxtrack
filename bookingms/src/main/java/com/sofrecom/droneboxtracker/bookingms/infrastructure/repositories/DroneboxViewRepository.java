package com.sofrecom.droneboxtracker.bookingms.infrastructure.repositories;

import com.sofrecom.droneboxtracker.bookingms.domain.projections.DroneboxView;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository class for the DroneBox Aggregate
 */
public interface DroneboxViewRepository extends JpaRepository<DroneboxView, String> {

     DroneboxView findByBookingId(String bookingId);


}

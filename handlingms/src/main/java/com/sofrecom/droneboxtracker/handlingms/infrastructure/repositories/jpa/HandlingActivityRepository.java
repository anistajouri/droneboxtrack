package com.sofrecom.droneboxtracker.handlingms.infrastructure.repositories.jpa;

import com.sofrecom.droneboxtracker.handlingms.domain.model.aggregates.HandlingActivity;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.DroneBoxBookingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandlingActivityRepository extends JpaRepository<HandlingActivity,Long> {
    HandlingActivity findByBookingId(DroneBoxBookingId droneboxBookingId);
}

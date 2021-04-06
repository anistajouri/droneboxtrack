package com.sofrecom.droneboxtracker.bookingms.application.queries;

import com.sofrecom.droneboxtracker.bookingms.domain.projections.DroneboxView;
import com.sofrecom.droneboxtracker.bookingms.domain.queries.DroneboxViewQuery;
import com.sofrecom.droneboxtracker.bookingms.domain.queries.DroneboxViewResult;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.BookingNotFoundException;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.repositories.DroneboxViewRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.concurrent.CompletableFuture;

/**
 * Projection Implementation for the DroneBox Projection Aggregate
 */
@Slf4j
@Service
public class DroneBoxProjectionService {
    private EntityManager entityManager;
    private QueryGateway queryGateway;

    private DroneboxViewRepository droneboxViewRepository;

    public DroneBoxProjectionService(QueryGateway queryGateway,EntityManager entityManager,DroneboxViewRepository droneboxViewRepository){
        this.entityManager = entityManager;
        this.queryGateway = queryGateway;
        this.droneboxViewRepository = droneboxViewRepository;
    }

    /**
     * Stores the DroneBox View Aggregate Projection
     * @param droneboxView
     */
    public void storeDroneboxView(DroneboxView droneboxView){
        droneboxViewRepository.save(droneboxView);
    }

    /**
     * Route the DroneboxView Query to the Corresponding Query Handler via the Query Gateway
     * @param bookingId
     * @return
     */
    public DroneboxViewResult queryDroneboxView(String bookingId){
       DroneboxViewQuery droneboxViewQuery = new DroneboxViewQuery(bookingId);
        DroneboxViewResult droneboxViewResult = null;
        try {
            droneboxViewResult = queryGateway.query(droneboxViewQuery,
                    DroneboxViewResult.class).join();
        } catch (Exception e) {
            throw new BookingNotFoundException(bookingId);
        }
        return droneboxViewResult;
    }


    /**
     * Retrieve the DroneBox View basis a Booking ID
     * @param bookingId
     * @return
     */
    public DroneboxView getDroneboxView(String bookingId){
        Query jpaQuery = entityManager.createNamedQuery("DroneboxView.findByBookingId",
                DroneboxView.class).setParameter("bookingId",bookingId);

        if (jpaQuery == null){
            throw new BookingNotFoundException(bookingId);
        }
        DroneboxView droneboxView = (DroneboxView)jpaQuery.getSingleResult();
        return droneboxView;
    }
}

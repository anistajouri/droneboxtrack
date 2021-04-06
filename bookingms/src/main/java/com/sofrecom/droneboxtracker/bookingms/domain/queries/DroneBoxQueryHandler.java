package com.sofrecom.droneboxtracker.bookingms.domain.queries;

import com.sofrecom.droneboxtracker.bookingms.domain.projections.DroneboxView;
import com.sofrecom.droneboxtracker.bookingms.domain.queries.DroneboxViewQuery;
import com.sofrecom.droneboxtracker.bookingms.domain.queries.DroneboxViewResult;
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.BookingNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.invoke.MethodHandles;

/**
 * Class which acts as the Query Handler for all queries related to the DroneBox Aggregate Projections
 */
@Slf4j
@Component
public class DroneBoxQueryHandler {
    private final EntityManager entityManager;

    public DroneBoxQueryHandler(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    /**
     * Query Handler Query which returns the DroneBox View for a Specific Query
     * @param droneboxViewQuery
     * @return DroneboxViewResult
     */
    @QueryHandler
    public DroneboxViewResult handle(DroneboxViewQuery droneboxViewQuery) {
        log.info("Handling {}", droneboxViewQuery);

        Query jpaQuery = entityManager.createNamedQuery("DroneboxView.findByBookingId",
                DroneboxView.class).setParameter("bookingId",droneboxViewQuery.getBookingId());

        if (jpaQuery == null){
            throw new BookingNotFoundException(droneboxViewQuery.getBookingId());
        }
        DroneboxViewResult result = new DroneboxViewResult((DroneboxView)jpaQuery.getSingleResult());

        log.info("Returning {}", result);
        return result;
    }

}

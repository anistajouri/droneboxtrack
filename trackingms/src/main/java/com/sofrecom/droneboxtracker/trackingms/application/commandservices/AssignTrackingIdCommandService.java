package com.sofrecom.droneboxtracker.trackingms.application.commandservices;


import com.sofrecom.droneboxtracker.trackingms.domain.model.aggregates.TrackingActivity;
import com.sofrecom.droneboxtracker.trackingms.domain.model.valueobjects.TrackingNumber;
import com.sofrecom.droneboxtracker.trackingms.domain.model.commands.AddTrackingEventCommand;
import com.sofrecom.droneboxtracker.trackingms.domain.model.commands.AssignTrackingNumberCommand;
import com.sofrecom.droneboxtracker.trackingms.infrastructure.repositories.jpa.TrackingActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;


/**
 * Application Service class for the Tracking Command Service
 */
@Slf4j
@Service
public class AssignTrackingIdCommandService {


    private TrackingActivityRepository trackingActivityRepository;


    public AssignTrackingIdCommandService(TrackingActivityRepository trackingActivityRepository){
        this.trackingActivityRepository = trackingActivityRepository;
    }
    /**
     * Service Command method to assign a tracking id to the booked dronebox
     * @return Tracking Number of the DroneBox
     */
    @Transactional // Inititate the Transaction
    public TrackingNumber assignTrackingNumberToDroneBox(AssignTrackingNumberCommand assignTrackingNumberCommand){
        String random = UUID.randomUUID().toString().toUpperCase();
        String trackingNumber = random.substring(0, random.indexOf("-"));
        assignTrackingNumberCommand.setTrackingNumber(trackingNumber);
        TrackingActivity activity = new TrackingActivity(assignTrackingNumberCommand);

        trackingActivityRepository.save(activity); //Store the Tracking Identifier
        return new TrackingNumber(trackingNumber);
    }

    /**
     * Service Command method to assign a route to a DroneBox
     * @param addTrackingEventCommand
     */
    @Transactional
    public void addTrackingEvent(AddTrackingEventCommand addTrackingEventCommand){
/*        TrackingActivity trackingActivity = trackingRepository.findByBookingNumber(
                        new BookingId(addTrackingEventCommand.getBookingId()));*/

        String random = UUID.randomUUID().toString().toUpperCase();
        String trackingNumber = random.substring(0, random.indexOf("-"));
        AssignTrackingNumberCommand assignTrackingNumberCommand = new AssignTrackingNumberCommand(addTrackingEventCommand.getBookingId(),trackingNumber);

/*            assignTrackingNumberCommand.setTrackingNumber(trackingNumber);*/
        TrackingActivity trackingActivity = new TrackingActivity(assignTrackingNumberCommand);
        log.info("----------------------------------------------------------");
        log.info("location: {}",addTrackingEventCommand.getLocation());
        log.info("Booking Id: {}",addTrackingEventCommand.getBookingId());
        log.info("Type Event: {}",addTrackingEventCommand.getEventType());
        log.info("Voyage number: {}",addTrackingEventCommand.getVoyageNumber());
        trackingActivity.addTrackingEvent(addTrackingEventCommand);
        trackingActivityRepository.save(trackingActivity);
    }


}

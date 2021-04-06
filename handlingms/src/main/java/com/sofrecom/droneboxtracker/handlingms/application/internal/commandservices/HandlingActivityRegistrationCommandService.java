package com.sofrecom.droneboxtracker.handlingms.application.internal.commandservices;

import com.sofrecom.droneboxtracker.handlingms.domain.model.aggregates.HandlingActivity;
import com.sofrecom.droneboxtracker.handlingms.domain.model.commands.HandlingActivityRegistrationCommand;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.DroneBoxBookingId;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.Location;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.Type;
import com.sofrecom.droneboxtracker.handlingms.domain.model.valueobjects.VoyageNumber;
import com.sofrecom.droneboxtracker.handlingms.infrastructure.repositories.jpa.HandlingActivityRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class HandlingActivityRegistrationCommandService {


        private HandlingActivityRepository handlingActivityRepository;

        public HandlingActivityRegistrationCommandService(HandlingActivityRepository handlingActivityRepository){
                this.handlingActivityRepository = handlingActivityRepository;
        }

        /**
         * Service Command method to register a new Handling Activity
         * @return BookingId of the DroneBoxBookingId
         */
        @Transactional
        public void registerHandlingActivityService(HandlingActivityRegistrationCommand handlingActivityRegistrationCommand){
                System.out.println("Handling Voyage Number is"+handlingActivityRegistrationCommand.getVoyageNumber());
                if(!handlingActivityRegistrationCommand.getVoyageNumber().equals("")) {
                        HandlingActivity handlingActivity = new HandlingActivity(
                                new DroneBoxBookingId(handlingActivityRegistrationCommand.getBookingId()),
                                handlingActivityRegistrationCommand.getCompletionTime(),
                                Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                                new Location(handlingActivityRegistrationCommand.getLocCode()),
                                new VoyageNumber(handlingActivityRegistrationCommand.getVoyageNumber()));
                        handlingActivityRepository.save(handlingActivity);

                }else{
                        HandlingActivity handlingActivity = new HandlingActivity(
                                new DroneBoxBookingId(handlingActivityRegistrationCommand.getBookingId()),
                                handlingActivityRegistrationCommand.getCompletionTime(),
                                Type.valueOf(handlingActivityRegistrationCommand.getHandlingType()),
                                new Location(handlingActivityRegistrationCommand.getLocCode()));
                        handlingActivityRepository.save(handlingActivity);
                }




        }
}

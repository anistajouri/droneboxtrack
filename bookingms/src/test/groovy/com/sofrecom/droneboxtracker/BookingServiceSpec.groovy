package com.sofrecom.droneboxtracker

import com.sofrecom.droneboxtracker.bookingms.BookingMSApplication
import com.sofrecom.droneboxtracker.bookingms.application.commands.DroneBoxBookingService
import com.sofrecom.droneboxtracker.bookingms.application.queries.DroneBoxProjectionService
import com.sofrecom.droneboxtracker.bookingms.domain.queries.DroneboxViewResult
import com.sofrecom.droneboxtracker.bookingms.infrastructure.config.Profiles
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.tocommand.BookDroneBoxCommandDTO
import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.BookingNotFoundException
import java.util.concurrent.CompletionException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification
import spock.lang.Title

// verifying the booking domain
@SpringBootTest(classes=[BookingMSApplication])
@ActiveProfiles([Profiles.TEST])
@Title("Booking Service Unit tests")
class BookingServiceSpec extends Specification implements SampleBookingDTO {

    // Testing command Service
    @Autowired
    DroneBoxBookingService droneBoxBookingService;

    // Testing queries Service
    @Autowired
    DroneBoxProjectionService droneBoxProjectionService;


    def "I should show a booked state"() {
        given: "I book a dronebox"
        expect: "I see current state booked"
    }


    def "I should show a routed state"() {
        given: "I book a dronebox"
        expect: "I see current state routed"
    }

    def "I should show a tracked state"() {
        given: "I book a dronebox"
            String bookingIdentifier = droneBoxBookingService.bookDroneBox(
                    BookDroneBoxCommandDTO.toCommandFromDTO(bookDroneBoxDto));
            Thread.sleep(5000);
        expect: "I see current state tracked"
          DroneboxViewResult droneBoxViewResult = droneBoxProjectionService.queryDroneboxView(
                  bookingIdentifier);
          println "--------->" + droneBoxViewResult.getDroneboxView().spec_destination_id;
  }


    def "should throw exception when asked for a booking that's not in the system"() {
        when: "system is asked for a booking that is not present"
        droneBoxProjectionService.queryDroneboxView("I put booking no");
        then: "throw book not found"
        thrown(BookingNotFoundException)
    }

    def "should list all bookings"() {
        given: "we have 2 bookings in system"
        when: "we ask for all bookings"
        then: "system returns the booking we have added"
    }

}




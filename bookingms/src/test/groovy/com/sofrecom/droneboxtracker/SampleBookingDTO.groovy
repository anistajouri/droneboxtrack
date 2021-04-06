package com.sofrecom.droneboxtracker

import com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto.BookDroneBoxDto
import groovy.transform.CompileStatic

import java.time.LocalDate
import java.time.ZoneId

@CompileStatic
trait SampleBookingDTO {
    BookDroneBoxDto bookDroneBoxDto = createBookingDroneBoxDto( 100, "X1", "X5", Date.from(LocalDate.of(2020, 8, 24).atStartOfDay(ZoneId.systemDefault()).toInstant()))

    static private BookDroneBoxDto createBookingDroneBoxDto(int amount, String origin, String dest, Date arrival) {
        return BookDroneBoxDto.builder()
                .bookingAmount(amount)
                .originLocation(origin)
                .destLocation(dest)
                .destArrivalDeadline(arrival)
                .build()
    }
}

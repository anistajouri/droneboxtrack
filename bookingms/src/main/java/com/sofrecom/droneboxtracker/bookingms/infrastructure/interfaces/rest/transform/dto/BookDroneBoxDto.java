package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto;

import java.util.Date;

import lombok.*;

/**
 * Dto class for the Reserve DroneBox Command API
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDroneBoxDto {
    private String bookingId;
    private int bookingAmount;
    private String originLocation;
    private String destLocation;
    private Date destArrivalDeadline;

}

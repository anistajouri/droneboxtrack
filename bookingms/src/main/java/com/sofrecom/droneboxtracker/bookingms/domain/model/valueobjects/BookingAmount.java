package com.sofrecom.droneboxtracker.bookingms.domain.model.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Booking Amount of the DroneBox
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingAmount implements Serializable {
    private int bookingAmount;
}

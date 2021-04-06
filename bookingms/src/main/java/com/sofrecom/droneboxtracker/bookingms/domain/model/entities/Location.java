package com.sofrecom.droneboxtracker.bookingms.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Location class represented by a unique 5-diigit UN Location code.
 */
@Getter
@Setter
@AllArgsConstructor
public class Location {
    private String locCode;
}

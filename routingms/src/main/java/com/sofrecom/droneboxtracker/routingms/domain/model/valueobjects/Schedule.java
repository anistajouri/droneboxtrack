package com.sofrecom.droneboxtracker.routingms.domain.model.valueobjects;


import com.sofrecom.droneboxtracker.routingms.domain.model.entities.DroneMovement;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.List;

/**
 * A Voyage schedule
 */
@Embeddable
public class Schedule {

    public static final Schedule EMPTY = new Schedule();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "voyage_id")
    private List<DroneMovement> droneMovements = Collections.emptyList();

    public Schedule() {
        // Nothing to initialize.
    }

    Schedule(List<DroneMovement> droneMovements) {
        this.droneMovements = droneMovements;
    }

    public List<DroneMovement> getDroneMovements() {
        return Collections.unmodifiableList(droneMovements);
    }
}

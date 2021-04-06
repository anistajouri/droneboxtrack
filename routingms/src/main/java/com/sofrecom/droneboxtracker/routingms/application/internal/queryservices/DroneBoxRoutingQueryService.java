package com.sofrecom.droneboxtracker.routingms.application.internal.queryservices;


import com.sofrecom.droneboxtracker.routingms.domain.model.aggregates.Voyage;
import com.sofrecom.droneboxtracker.routingms.infrastructure.repositories.jpa.VoyageRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Application Service class for the DroneBox Routing Query service
 */
@Service
public class DroneBoxRoutingQueryService {

    private VoyageRepository voyageRepository; // Inject Dependencies

    public DroneBoxRoutingQueryService(VoyageRepository voyageRepository){
        this.voyageRepository = voyageRepository;
    }
    /**
     * Returns all Voyages
     * @return
     */
    @Transactional
    public List<Voyage> findAll(){
        return voyageRepository.findAll();
    }


}

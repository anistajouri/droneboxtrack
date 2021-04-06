package com.sofrecom.droneboxtracker.handlingms.interfaces.rest;

import com.sofrecom.droneboxtracker.handlingms.application.internal.commandservices.HandlingActivityRegistrationCommandService;
import com.sofrecom.droneboxtracker.handlingms.domain.model.aggregates.HandlingActivity;
import com.sofrecom.droneboxtracker.handlingms.interfaces.rest.dto.HandlingActivityRegistrationResource;
import com.sofrecom.droneboxtracker.handlingms.interfaces.rest.transform.HandlingActivityRegistrationCommandDTOAssembler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for the REST API
 */
@Controller    // This means that this class is a Controller
@RequestMapping("/droneboxhandling")
public  class DroneBoxHandlingController {


    private HandlingActivityRegistrationCommandService handlingActivityRegistrationCommandService; // Application Service Dependency

    /**
     * Provide the dependencies
     * @param handlingActivityRegistrationCommandService
     */
    public DroneBoxHandlingController(HandlingActivityRegistrationCommandService handlingActivityRegistrationCommandService){
        this.handlingActivityRegistrationCommandService = handlingActivityRegistrationCommandService;
    }

    /**
     * POST method to register Handling Activities
     * @param handlingActivityRegistrationResource
     */
    @PostMapping
    @ResponseBody
    public String registerHandlingActivity(@RequestBody HandlingActivityRegistrationResource handlingActivityRegistrationResource){
        handlingActivityRegistrationCommandService.registerHandlingActivityService(HandlingActivityRegistrationCommandDTOAssembler.toCommandFromDTO(handlingActivityRegistrationResource));
        return "Handling Activity Registered";
    }
}

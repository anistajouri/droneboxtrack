package com.sofrecom.droneboxtracker.bookingms.infrastructure.interfaces.rest.transform.dto;

import java.util.List;

public class DroneBoxRouteDto {

    private String bookingId;

    private List<Route> routes;

    public DroneBoxRouteDto(String bookingId,List<Route> routes){
        this.setBookingId(bookingId);
        this.setRoutes(routes);
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}

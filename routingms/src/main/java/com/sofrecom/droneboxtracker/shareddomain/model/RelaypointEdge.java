package com.sofrecom.droneboxtracker.shareddomain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents an edge in a path through a graph, describing the route of a
 * dronebox.
 */
public class RelaypointEdge implements Serializable {

    private String voyageNumber;
    private String fromLocCode;
    private String toLocCode;
    private Date fromDate;
    private Date toDate;

    public RelaypointEdge() {
        // Nothing to do.
    }

    public RelaypointEdge(String voyageNumber, String fromLocCode,
            String toLocCode, Date fromDate, Date toDate) {
        this.voyageNumber = voyageNumber;
        this.fromLocCode = fromLocCode;
        this.toLocCode = toLocCode;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getVoyageNumber() {
        return voyageNumber;
    }

    public void setVoyageNumber(String voyageNumber) {
        this.voyageNumber = voyageNumber;
    }

    public String getFromLocCode() {
        return fromLocCode;
    }

    public void setFromLocCode(String fromLocCode) {
        this.fromLocCode = fromLocCode;
    }

    public String getToLocCode() {
        return toLocCode;
    }

    public void setToLocCode(String toLocCode) {
        this.toLocCode = toLocCode;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "RelaypointEdge{" + "voyageNumber=" + voyageNumber
                + ", fromLocCode=" + fromLocCode + ", toLocCode="
                + toLocCode + ", fromDate=" + fromDate
                + ", toDate=" + toDate + '}';
    }
}
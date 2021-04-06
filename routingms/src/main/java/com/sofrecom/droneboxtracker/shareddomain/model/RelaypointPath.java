package com.sofrecom.droneboxtracker.shareddomain.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class RelaypointPath implements Serializable {

    private List<RelaypointEdge> relaypointEdges;

    public RelaypointPath() {
        this.relaypointEdges = new ArrayList<>();
    }

    public RelaypointPath(List<RelaypointEdge> relaypointEdges) {
        this.relaypointEdges = relaypointEdges;
    }

    public List<RelaypointEdge> getRelaypointEdges() {
        return relaypointEdges;
    }

    public void setRelaypointEdges(List<RelaypointEdge> relaypointEdges) {
        this.relaypointEdges = relaypointEdges;
    }

    @Override
    public String toString() {
        return "RelaypointPath{" + "relaypointEdges=" + relaypointEdges + '}';
    }
}

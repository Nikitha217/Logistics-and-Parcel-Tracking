package com.kce.logistics.model;

import java.util.ArrayList;
import java.util.List;

public class Shipment {
    private String id;
    private String origin;
    private String destination;
    private List<Parcel> parcels;
    private List<Hub> route;
    private boolean closed;

    public Shipment(String id, String origin, String destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.parcels = new ArrayList<>();
        this.route = new ArrayList<>();
        this.closed = false;
    }

    public void addParcel(Parcel p) {
        parcels.add(p);
    }

    public void addHub(Hub h) {
        route.add(h);
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public boolean canClose() {
        for (Parcel p : parcels) {
            if (!(p.getStatus() == Status.DELIVERED || p.getStatus() == Status.RETURNED)) {
                return false;
            }
        }
        return true;
    }

    public boolean close() {
        if (canClose()) {
            closed = true;
            return true;
        }
        return false;
    }

    public String summary() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Shipment %s: %s -> %s\n", id, origin, destination));
        sb.append("Route: ");
        for (Hub h : route) sb.append(h.getId()).append(" ");
        sb.append("\nParcels:\n");
        for (Parcel p : parcels) sb.append(" - ").append(p).append("\n");
        sb.append("Closed: ").append(closed).append("\n");
        return sb.toString();
    }
}

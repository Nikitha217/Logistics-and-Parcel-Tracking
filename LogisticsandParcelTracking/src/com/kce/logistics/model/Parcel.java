package com.kce.logistics.model;

import java.util.ArrayList;
import java.util.List;

public class Parcel {
    private String id;
    private String description;
    private double weightKg;
    private Status status;
    private List<Event> timeline;
    private ProofOfDelivery proof;

    public Parcel(String id, String description, double weightKg) {
        this.id = id;
        this.description = description;
        this.weightKg = weightKg;
        this.status = Status.CREATED;
        this.timeline = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public ProofOfDelivery getProof() {
        return proof;
    }

    public void addEvent(Event e) {
        timeline.add(e);
        if (e instanceof ScanEvent) {
            if (status == Status.CREATED) status = Status.IN_TRANSIT;
        } else if (e instanceof DeliveryAttempt) {
            DeliveryAttempt da = (DeliveryAttempt) e;
            if (da.isSuccess()) {
                status = Status.DELIVERED;
                this.proof = da.getPod();
            }
        }
    }

    public void markReturned(String note) {
        status = Status.RETURNED;
        timeline.add(new Event(note) {
            @Override
            public String describe() {
                return String.format("[%s] RETURNED - %s", timestamp, note);
            }
        });
    }

    public List<Event> getTimeline() {
        return timeline;
    }

    @Override
    public String toString() {
        return String.format("Parcel %s: %s (%.2f kg) Status: %s%s",
                id, description, weightKg, status,
                (proof != null ? " POD: " + proof : ""));
    }
}

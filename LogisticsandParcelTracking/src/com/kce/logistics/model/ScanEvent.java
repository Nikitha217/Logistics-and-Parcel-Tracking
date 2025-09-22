package com.kce.logistics.model;

public class ScanEvent extends Event {
    private String hubId;
    private String parcelId;

    public ScanEvent(String parcelId, String hubId, String note) {
        super(note);
        this.hubId = hubId;
        this.parcelId = parcelId;
    }

    @Override
    public String describe() {
        return String.format("[%s] SCAN at Hub %s for Parcel %s - %s",
                timestamp, hubId, parcelId, note);
    }
}

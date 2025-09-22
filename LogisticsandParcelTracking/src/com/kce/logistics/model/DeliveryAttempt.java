package com.kce.logistics.model;

public class DeliveryAttempt extends Event {
    private String parcelId;
    private boolean success;
    private ProofOfDelivery pod;

    public DeliveryAttempt(String parcelId, boolean success, String note, ProofOfDelivery pod) {
        super(note);
        this.parcelId = parcelId;
        this.success = success;
        this.pod = pod;
    }

    public boolean isSuccess() {
        return success;
    }

    public ProofOfDelivery getPod() {
        return pod;
    }

    @Override
    public String describe() {
        if (success) {
            return String.format("[%s] DELIVERY SUCCESS for parcel %s - %s; POD: %s",
                    timestamp, parcelId, note, pod);
        } else {
            return String.format("[%s] DELIVERY FAILED for parcel %s - %s",
                    timestamp, parcelId, note);
        }
    }
}

package com.kce.logistics.model;

import java.time.LocalDateTime;

public class ProofOfDelivery {
    private String receiverNameOrCode;
    private LocalDateTime timestamp;

    public ProofOfDelivery(String receiverNameOrCode) {
        this.receiverNameOrCode = receiverNameOrCode;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("POD by '%s' at %s", receiverNameOrCode, timestamp);
    }
}

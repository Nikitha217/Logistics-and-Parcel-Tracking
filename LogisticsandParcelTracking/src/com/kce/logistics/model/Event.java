package com.kce.logistics.model;

import java.time.LocalDateTime;

public abstract class Event {
    protected LocalDateTime timestamp;
    protected String note;

    public Event(String note) {
        this.timestamp = LocalDateTime.now();
        this.note = note;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getNote() {
        return note;
    }

    public abstract String describe();
}

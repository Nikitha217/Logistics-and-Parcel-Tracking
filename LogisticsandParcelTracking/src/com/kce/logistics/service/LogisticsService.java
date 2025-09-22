package com.kce.logistics.service;

import com.kce.logistics.exception.LogisticsException;
import com.kce.logistics.model.*;

import java.util.*;

public class LogisticsService {
    private Map<String, Customer> customers = new HashMap<>();
    private Map<String, Parcel> parcels = new HashMap<>();
    private Map<String, Shipment> shipments = new HashMap<>();
    private Map<String, Hub> hubs = new HashMap<>();

    public void addCustomer(Customer c) {
        customers.put(c.toString(), c);
    }

    public void addParcel(Parcel p) {
        parcels.put(p.getId(), p);
    }

    public void addHub(Hub h) {
        hubs.put(h.getId(), h);
    }

    public void addShipment(Shipment s) {
        shipments.put(s.summary(), s);
    }

    public Parcel getParcel(String id) throws LogisticsException {
        Parcel p = parcels.get(id);
        if (p == null) throw new LogisticsException("Parcel not found: " + id);
        return p;
    }

    public Hub getHub(String id) throws LogisticsException {
        Hub h = hubs.get(id);
        if (h == null) throw new LogisticsException("Hub not found: " + id);
        return h;
    }

    public Shipment getShipment(String id) throws LogisticsException {
        for (Shipment s : shipments.values()) {
            if (s.summary().contains(id)) return s;
        }
        throw new LogisticsException("Shipment not found: " + id);
    }

    public Map<String, Parcel> getParcels() {
        return parcels;
    }

    public Map<String, Shipment> getShipments() {
        return shipments;
    }
}

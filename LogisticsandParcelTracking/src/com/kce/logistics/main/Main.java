package com.kce.logistics.main;

import com.kce.logistics.exception.LogisticsException;
import com.kce.logistics.model.*;
import com.kce.logistics.service.LogisticsService;
import com.kce.logistics.util.InputUtil;

public class Main {
    private static LogisticsService service = new LogisticsService();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = InputUtil.prompt("Choice: ");
            try {
                switch (choice) {
                    case "1" -> createParcel();
                    case "2" -> createShipment();
                    case "3" -> addHub();
                    case "4" -> recordScan();
                    case "5" -> recordDeliveryAttempt();
                    case "6" -> showParcelStatus();
                    case "7" -> showShipmentSummary();
                    case "0" -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Exiting system...");
    }

    private static void printMenu() {
        System.out.println("\n--- Logistics Menu ---");
        System.out.println("1. Create Parcel");
        System.out.println("2. Create Shipment");
        System.out.println("3. Add Hub");
        System.out.println("4. Record Scan");
        System.out.println("5. Record Delivery Attempt");
        System.out.println("6. Show Parcel Status");
        System.out.println("7. Show Shipment Summary");
        System.out.println("0. Exit");
    }

    private static void createParcel() {
        String id = InputUtil.prompt("Parcel ID: ");
        String desc = InputUtil.prompt("Description: ");
        double w = Double.parseDouble(InputUtil.prompt("Weight (kg): "));
        Parcel p = new Parcel(id, desc, w);
        service.addParcel(p);
        System.out.println("Created: " + p);
    }

    private static void createShipment() {
        String id = InputUtil.prompt("Shipment ID: ");
        String origin = InputUtil.prompt("Origin: ");
        String dest = InputUtil.prompt("Destination: ");
        Shipment s = new Shipment(id, origin, dest);
        service.addShipment(s);
        System.out.println("Shipment created.");
    }

    private static void addHub() {
        String id = InputUtil.prompt("Hub ID: ");
        String name = InputUtil.prompt("Name: ");
        String loc = InputUtil.prompt("Location: ");
        service.addHub(new Hub(id, name, loc));
        System.out.println("Hub added.");
    }

    private static void recordScan() throws LogisticsException {
        String pid = InputUtil.prompt("Parcel ID: ");
        String hid = InputUtil.prompt("Hub ID: ");
        String note = InputUtil.prompt("Note: ");
        Parcel p = service.getParcel(pid);
        Hub h = service.getHub(hid);
        ScanEvent se = new ScanEvent(pid, h.getId(), note);
        p.addEvent(se);
        System.out.println("Scan recorded.");
    }

    private static void recordDeliveryAttempt() throws LogisticsException {
        String pid = InputUtil.prompt("Parcel ID: ");
        String outcome = InputUtil.prompt("Outcome (success/fail/return): ").toLowerCase();
        String note = InputUtil.prompt("Note: ");
        Parcel p = service.getParcel(pid);
        switch (outcome) {
            case "success" -> {
                String podStr = InputUtil.prompt("Receiver Name/Code: ");
                ProofOfDelivery pod = new ProofOfDelivery(podStr);
                p.addEvent(new DeliveryAttempt(pid, true, note, pod));
                System.out.println("Delivery success.");
            }
            case "fail" -> {
                p.addEvent(new DeliveryAttempt(pid, false, note, null));
                System.out.println("Delivery failed.");
            }
            case "return" -> {
                p.markReturned(note);
                System.out.println("Parcel returned.");
            }
            default -> throw new LogisticsException("Unknown outcome.");
        }
    }

    private static void showParcelStatus() throws LogisticsException {
        String pid = InputUtil.prompt("Parcel ID: ");
        Parcel p = service.getParcel(pid);
        System.out.println(p);
        for (Event e : p.getTimeline()) {
            System.out.println(" - " + e.describe());
        }
    }

    private static void showShipmentSummary() throws LogisticsException {
        String sid = InputUtil.prompt("Shipment ID: ");
        Shipment s = service.getShipment(sid);
        System.out.println(s.summary());
    }
}

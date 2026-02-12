# Logistics and Parcel Tracking System

## Project Overview
  The Logistics and Parcel Tracking System is a Java-based console application designed to manage parcels, shipments, hubs, scans, and deliveries efficiently.

  The system allows logistics operators to create shipments, track parcel movements across hubs, record delivery attempts, and store proof of delivery. It provides a simple menu-driven interface for managing logistics operations.

  This project demonstrates strong implementation of Object-Oriented Programming (OOP) principles using Java.

## Objectives

The system is designed to:

- Create and manage parcels
- Create and manage shipments
- Record hub scans (parcel movement tracking)
- Record delivery attempts
- Store proof of delivery
- Track parcel status
- View shipment summaries
- Provide a console-based interactive menu


## Technologies Used

- **Programming Language:** Java
- **Concepts Used:** OOP (Encapsulation, Abstraction, Inheritance, Polymorphism)
- **Interface:** Console-based Menu System
- **IDE:** Eclipse

 
## Project Structure
 
```plaintext
LogisticsandParcelTracking
│
├── com.kce.logistics.exception
│   └── LogisticsException.java
│
├── com.kce.logistics.main
│   └── Main.java
│
├── com.kce.logistics.model
│   ├── Customer.java
│   ├── DeliveryAttempt.java
│   ├── Event.java
│   ├── Hub.java
│   ├── Parcel.java
│   ├── ProofOfDelivery.java
│   ├── ScanEvent.java
│   ├── Shipment.java
│   └── Status.java
│
├── com.kce.logistics.service
│   └── LogisticsService.java
│
└── com.kce.logistics.util
    └── InputUtil.java
 ``` 
    
## Features

### Parcel Management
- Create new parcels
- Assign parcels to shipments
- Track parcel status

### Shipment Management
- Create shipments containing multiple parcels
- View shipment summary details
- Monitor shipment progress

### Hub Scans
- Record parcel scans at different hubs
- Update parcel location
- Maintain scan history

### Delivery Management
- Record delivery attempts
- Mark parcels as delivered
- Store proof of delivery (receiver name / confirmation note)
- Handle failed delivery attempts

### Tracking
- View current parcel status
- View full tracking history
- Display shipment summary

## How to Run the Project

1. Open Eclipse and import/open the project `LogisticsandParcelTracking`
2. Ensure Java 21 is configured  
   - Project → Properties → Java Build Path → JRE System Library → JavaSE-21
3. Run the application  
   - Navigate to `com.kce.logistics.main.Main.java`  
   - Right-click → Run As → Java Application

## Output
<img width="602" height="676" alt="Screenshot 2026-02-12 112851" src="https://github.com/user-attachments/assets/5fc3d2cf-4665-4d9e-a98a-cb64b12c0611" />

<img width="579" height="658" alt="Screenshot 2026-02-12 112907" src="https://github.com/user-attachments/assets/f161eb9f-7071-44ff-87d3-e6f7bd2e44a3" />

<img width="1268" height="680" alt="Screenshot 2026-02-12 112925" src="https://github.com/user-attachments/assets/052d112f-5de3-4774-b5a4-74eb159e8655" />

<img width="508" height="616" alt="Screenshot 2026-02-12 112938" src="https://github.com/user-attachments/assets/63a3a74f-81ec-492d-8c6d-28de905835d5" />

Student Details
Name: Nikitha S
Roll No: 717823P136

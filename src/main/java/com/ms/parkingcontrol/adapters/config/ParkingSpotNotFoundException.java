package com.ms.parkingcontrol.adapters.config;

public class ParkingSpotNotFoundException extends RuntimeException {
    public ParkingSpotNotFoundException(String message) {
        super(message);
    }

    public ParkingSpotNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

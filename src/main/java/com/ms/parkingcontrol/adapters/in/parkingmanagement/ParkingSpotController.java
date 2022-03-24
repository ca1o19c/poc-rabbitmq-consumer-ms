package com.ms.parkingcontrol.adapters.in.parkingmanagement;

import com.ms.parkingcontrol.adapters.dto.ParkingSpotRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ParkingSpotController {
    ResponseEntity<Object> saveParkingSpot(ParkingSpotRequest parkingSpotRequest);
    ResponseEntity<Object> getParkingSpot(UUID id);
}

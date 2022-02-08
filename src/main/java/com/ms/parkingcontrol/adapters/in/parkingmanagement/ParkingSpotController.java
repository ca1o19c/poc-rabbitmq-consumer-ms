package com.ms.parkingcontrol.adapters.in.parkingmanagement;

import com.ms.parkingcontrol.adapters.dto.ParkingSpotDto;
import org.springframework.http.ResponseEntity;

public interface ParkingSpotController {
    ResponseEntity<Object> saveParkingSpot(ParkingSpotDto parkingSpotDto);
}

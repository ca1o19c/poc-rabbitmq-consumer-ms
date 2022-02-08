package com.ms.parkingcontrol.ports.out.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

public interface ParkingSpotPortOut {
    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
}

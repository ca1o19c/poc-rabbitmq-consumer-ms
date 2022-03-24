package com.ms.parkingcontrol.ports.in.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

public interface ParkingSpotPortInbound {
    ParkingSpot saveParkingSpotFacade(ParkingSpot parkingSpot);
}

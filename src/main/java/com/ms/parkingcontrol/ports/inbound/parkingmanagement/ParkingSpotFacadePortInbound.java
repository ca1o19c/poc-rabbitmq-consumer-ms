package com.ms.parkingcontrol.ports.inbound.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

public interface ParkingSpotFacadePortInbound {

    ParkingSpot saveParkingSpotFacade(ParkingSpot parkingSpot);
}

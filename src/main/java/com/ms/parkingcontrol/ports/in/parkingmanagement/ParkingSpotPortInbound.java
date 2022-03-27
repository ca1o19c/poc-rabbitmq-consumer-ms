package com.ms.parkingcontrol.ports.in.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.FilteredParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;


public interface ParkingSpotPortInbound {

    FilteredParkingSpot getAllParkingSpots(ParkingSpotSearch parkingSpotSearch);

    ParkingSpot getParkingSpot(String id);
}

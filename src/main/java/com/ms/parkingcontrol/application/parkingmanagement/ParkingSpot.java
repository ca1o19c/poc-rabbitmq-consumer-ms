package com.ms.parkingcontrol.application.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.FilteredParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortInbound;
import com.ms.parkingcontrol.ports.out.parkingmanagement.ParkingSpotStoreDatabasePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ParkingSpot implements ParkingSpotPortInbound {

    @Autowired
    private ParkingSpotStoreDatabasePortOutbound parkingSpotStoreDatabasePortOutbound;

    @Override
    public FilteredParkingSpot getAllParkingSpots(ParkingSpotSearch parkingSpotSearch) {
        return parkingSpotStoreDatabasePortOutbound.getAllParkingSpots(parkingSpotSearch);
    }

    @Override
    public com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot getParkingSpot(String id) {
        return parkingSpotStoreDatabasePortOutbound.getParkingSpot(id);
    }
}

package com.ms.parkingcontrol.application.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortIn;
import com.ms.parkingcontrol.ports.out.parkingmanagement.ParkingSpotPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ParkingSpotService implements ParkingSpotPortIn {

    @Autowired
    private ParkingSpotPortOut parkingSpotPortOut;

    @Override
    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.created();
        return this.parkingSpotPortOut.saveParkingSpot(parkingSpot);
    }
}

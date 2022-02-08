package com.ms.parkingcontrol.adapters.out.parkingmanagement.database;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.out.parkingmanagement.MongoParkingSpot;
import com.ms.parkingcontrol.ports.out.parkingmanagement.ParkingSpotPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class MongoParkingSpotOut implements ParkingSpotPortOut {

    @Autowired
    private MongoParkingSpot mongoParkingSpot;

    @Override
    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        return this.mongoParkingSpot.save(parkingSpot);
    }
}

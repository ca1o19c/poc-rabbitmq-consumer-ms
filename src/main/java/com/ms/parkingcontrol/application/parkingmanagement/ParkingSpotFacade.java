package com.ms.parkingcontrol.application.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.MongoOperationsPortInbound;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ParkingSpotFacade implements ParkingSpotPortInbound {

    @Autowired
    private ParkingSpotRequisites parkingSpotRequisites;

    @Autowired
    private MongoOperationsPortInbound mongoOperationsPortInbound;

    @Override
    public ParkingSpot saveParkingSpotFacade(ParkingSpot parkingSpot) {

        parkingSpotRequisites.verifyLicensePlateCar(parkingSpot.getLicensePlateCar());

        parkingSpotRequisites.verifyParkingSpotNumber(parkingSpot.getParkingSpotNumber());

        parkingSpotRequisites.verifyApartmentAndBlock(parkingSpot.getApartment(), parkingSpot.getBlock());

        return mongoOperationsPortInbound.saveParkingSpot(parkingSpot);
    }
}

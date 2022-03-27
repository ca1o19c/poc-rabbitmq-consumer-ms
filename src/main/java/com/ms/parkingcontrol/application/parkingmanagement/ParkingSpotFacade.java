package com.ms.parkingcontrol.application.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotFacadePortInbound;
import com.ms.parkingcontrol.ports.out.parkingmanagement.ParkingSpotStoreDatabasePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ParkingSpotFacade implements ParkingSpotFacadePortInbound {

    @Autowired
    private ParkingSpotRequisites parkingSpotRequisites;

    @Autowired
    private ParkingSpotStoreDatabasePortOutbound mongoDatabaseStorePortOutbound;

    @Override
    public ParkingSpot saveParkingSpotFacade(ParkingSpot parkingSpot) {

        parkingSpotRequisites.verifyLicensePlateCar(parkingSpot.getLicensePlateCar());

        parkingSpotRequisites.verifyParkingSpotNumber(parkingSpot.getParkingSpotNumber());

        parkingSpotRequisites.verifyApartmentAndBlock(parkingSpot.getApartment(), parkingSpot.getBlock());

        return mongoDatabaseStorePortOutbound.saveParkingSpot(parkingSpot);
    }
}

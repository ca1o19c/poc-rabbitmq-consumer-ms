package com.ms.parkingcontrol.application.parkingmanagement;

import com.ms.parkingcontrol.adapters.config.ConflictParkingSpotException;
import com.ms.parkingcontrol.ports.inbound.parkingmanagement.ParkingSpotRequisitesPortInbound;
import com.ms.parkingcontrol.ports.outbound.parkingmanagement.ParkingSpotStoreDatabasePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ParkingSpotRequisites implements ParkingSpotRequisitesPortInbound {

    @Autowired
    private ParkingSpotStoreDatabasePortOutbound mongoDatabaseStorePortOutbound;

    @Override
    public void verifyLicensePlateCar(String licensePlateCar) throws ConflictParkingSpotException {
        String byLicensePlateCar = mongoDatabaseStorePortOutbound.findByLicensePlateCar(licensePlateCar);

        if (byLicensePlateCar != null)
            throw new ConflictParkingSpotException("License Plate Car is already in use.");
    }

    @Override
    public void verifyParkingSpotNumber(String parkingSpotNumber) throws ConflictParkingSpotException {
        String byParkingSpotNumber = mongoDatabaseStorePortOutbound.findByParkingSpotNumber(parkingSpotNumber);

        if (byParkingSpotNumber != null)
            throw new ConflictParkingSpotException("Parking Spot is already in use.");
    }

    public void verifyApartmentAndBlock(String apartment, String block) throws ConflictParkingSpotException {
        String byApartment = mongoDatabaseStorePortOutbound.findByApartment(apartment);
        String byBlock = mongoDatabaseStorePortOutbound.findByBlock(block);

        if (byApartment != null || byBlock != null)
            throw new ConflictParkingSpotException("Parking Spot already registered for this apartment/block.");
    }
}

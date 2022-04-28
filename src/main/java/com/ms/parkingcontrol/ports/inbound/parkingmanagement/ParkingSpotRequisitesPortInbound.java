package com.ms.parkingcontrol.ports.inbound.parkingmanagement;

import com.ms.parkingcontrol.adapters.config.ConflictParkingSpotException;

public interface ParkingSpotRequisitesPortInbound {

    void verifyLicensePlateCar(String licensePlateCar) throws ConflictParkingSpotException;

    void verifyParkingSpotNumber(String parkingSpotNumber) throws ConflictParkingSpotException;

    void verifyApartmentAndBlock(String apartment, String block) throws ConflictParkingSpotException;
}

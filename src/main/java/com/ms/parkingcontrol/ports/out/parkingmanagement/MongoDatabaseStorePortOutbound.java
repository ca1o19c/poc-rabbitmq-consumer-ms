package com.ms.parkingcontrol.ports.out.parkingmanagement;

import com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot;

import java.util.Optional;
import java.util.UUID;

public interface MongoDatabaseStorePortOutbound {
    Optional<ParkingSpot> searchByLicensePlateCar(String licensePlateCar);
    Optional<ParkingSpot> searchByParkingSpotNumber(String parkingSpotNumber);
    Optional<ParkingSpot> searchByApartment(String apartment);
    Optional<ParkingSpot> searchByBlock(String block);
    ParkingSpot saveParkingSpot(com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot parkingSpot);
    Optional<ParkingSpot> getParkingSpot(UUID id);
}

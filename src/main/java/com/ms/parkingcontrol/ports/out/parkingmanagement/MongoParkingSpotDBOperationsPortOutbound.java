package com.ms.parkingcontrol.ports.out.parkingmanagement;

import com.ms.parkingcontrol.adapters.out.parkingmanagement.ResearchedParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;

import java.util.Optional;

public interface MongoParkingSpotDBOperationsPortOutbound {
    Optional<com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot> searchByLicensePlateCar(String licensePlateCar);

    Optional<com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot> searchByParkingSpotNumber(String parkingSpotNumber);

    Optional<com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot> searchByApartment(String apartment);

    Optional<com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot> searchByBlock(String block);

    com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot saveParkingSpot(com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot parkingSpot);

    Optional<com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot> getParkingSpot(String id);

    ResearchedParkingSpot getAll(ParkingSpotSearch parkingSpotSearch);
}

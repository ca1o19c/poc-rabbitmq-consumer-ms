package com.ms.parkingcontrol.ports.outbound.parkingmanagement;

import com.ms.parkingcontrol.adapters.outbound.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.adapters.outbound.parkingmanagement.ResearchedParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;

import java.util.Optional;

public interface MongoParkingSpotDBOperationsPortOutbound {
    Optional<ParkingSpot> searchByLicensePlateCar(String licensePlateCar);

    Optional<ParkingSpot> searchByParkingSpotNumber(String parkingSpotNumber);

    Optional<ParkingSpot> searchByApartment(String apartment);

    Optional<ParkingSpot> searchByBlock(String block);

    ParkingSpot saveParkingSpot(com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot parkingSpot);

    Optional<ParkingSpot> getParkingSpot(String id);

    ResearchedParkingSpot getAll(ParkingSpotSearch parkingSpotSearch);
}

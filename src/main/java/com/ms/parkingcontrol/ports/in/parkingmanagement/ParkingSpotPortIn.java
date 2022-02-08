package com.ms.parkingcontrol.ports.in.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

public interface ParkingSpotPortIn {
    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);

    boolean existsByApartmentAndBlock(String apartment, String block);
}

package com.ms.parkingcontrol.ports.out.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

public interface ParkingSpotPortOut {
    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);

    boolean existsByLicensePlateCar(String licensePlateCar);

    boolean existsByApartmentAndBlock(String apartment, String block);

    boolean existsByParkingSpotNumber(String parkingSpotNumber);
}

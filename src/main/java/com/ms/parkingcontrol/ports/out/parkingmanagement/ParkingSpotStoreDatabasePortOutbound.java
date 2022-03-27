package com.ms.parkingcontrol.ports.out.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.FilteredParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;

public interface ParkingSpotStoreDatabasePortOutbound {

    String findByLicensePlateCar(String licensePlateCar);

    String findByParkingSpotNumber(String parkingSpotNumber);

    String findByApartment(String apartment);

    String findByBlock(String block);

    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);

    ParkingSpot getParkingSpot(String id);

    FilteredParkingSpot getAllParkingSpots(ParkingSpotSearch parkingSpotSearch);
}

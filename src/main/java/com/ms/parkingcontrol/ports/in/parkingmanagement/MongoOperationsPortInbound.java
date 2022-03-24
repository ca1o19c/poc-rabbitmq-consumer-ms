package com.ms.parkingcontrol.ports.in.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

public interface MongoOperationsPortInbound {
    String findByLicensePlateCar(String licensePlateCar);
    String findByParkingSpotNumber(String parkingSpotNumber);
    String findByApartment(String apartment);
    String findByBlock(String block);
    ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
}

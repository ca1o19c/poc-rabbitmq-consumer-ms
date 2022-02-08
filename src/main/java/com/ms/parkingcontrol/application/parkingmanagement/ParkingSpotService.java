package com.ms.parkingcontrol.application.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortIn;
import com.ms.parkingcontrol.ports.out.parkingmanagement.ParkingSpotPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ParkingSpotService implements ParkingSpotPortIn {

    @Autowired
    private ParkingSpotPortOut parkingSpotPortOut;

    @Override
    public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.created();
        return this.parkingSpotPortOut.saveParkingSpot(parkingSpot);
    }

    @Override
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return this.parkingSpotPortOut.existsByLicensePlateCar(licensePlateCar);
    }

    @Override
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return this.parkingSpotPortOut.existsByParkingSpotNumber(parkingSpotNumber);
    }

    @Override
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return this.parkingSpotPortOut.existsByApartmentAndBlock(apartment, block);
    }
}

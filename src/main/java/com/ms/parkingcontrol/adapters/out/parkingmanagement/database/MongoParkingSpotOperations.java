package com.ms.parkingcontrol.adapters.out.parkingmanagement.database;

import com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.MongoOperationsPortInbound;
import com.ms.parkingcontrol.ports.out.parkingmanagement.MongoDatabaseStorePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class MongoParkingSpotOperations implements MongoOperationsPortInbound {

    @Autowired
    private MongoDatabaseStorePortOutbound mongoDatabaseStorePortOutbound;

    @Override
    public com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot saveParkingSpot(com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot parkingSpot) {
        ParkingSpot parkingSpotDocument = mongoDatabaseStorePortOutbound.saveParkingSpot(parkingSpot);

        com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot entity = com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot.builder()
                .withId(parkingSpotDocument.getId())
                .withParkingSpotNumber(parkingSpotDocument.getParkingSpotNumber())
                .withLicensePlateCar(parkingSpotDocument.getLicensePlateCar())
                .withApartment(parkingSpotDocument.getApartment())
                .withBlock(parkingSpotDocument.getBlock())
                .withBrandCar(parkingSpotDocument.getBrandCar())
                .withColorCar(parkingSpotDocument.getColorCar())
                .withLicensePlateCar(parkingSpotDocument.getLicensePlateCar())
                .withModelCar(parkingSpotDocument.getModelCar())
                .withResponsibleName(parkingSpotDocument.getResponsibleName())
                .withRegistrationDate(parkingSpotDocument.getRegistrationDate())
                .build();

        return entity;
    }

    @Override
    public String findByLicensePlateCar(String licensePlateCar) {
        ParkingSpot parkingSpot = mongoDatabaseStorePortOutbound.searchByLicensePlateCar(licensePlateCar).orElse(new ParkingSpot());

        return parkingSpot.getLicensePlateCar();
    }

    @Override
    public String findByParkingSpotNumber(String parkingSpotNumber) {
        ParkingSpot parkingSpot = mongoDatabaseStorePortOutbound.searchByParkingSpotNumber(parkingSpotNumber).orElse(new ParkingSpot());

        return parkingSpot.getParkingSpotNumber();
    }

    @Override
    public String findByApartment(String apartment) {
        ParkingSpot parkingSpot = mongoDatabaseStorePortOutbound.searchByApartment(apartment).orElse(new ParkingSpot());

        return parkingSpot.getApartment();
    }

    @Override
    public String findByBlock(String block) {
        ParkingSpot parkingSpot = mongoDatabaseStorePortOutbound.searchByBlock(block).orElse(new ParkingSpot());

        return parkingSpot.getBlock();
    }
}

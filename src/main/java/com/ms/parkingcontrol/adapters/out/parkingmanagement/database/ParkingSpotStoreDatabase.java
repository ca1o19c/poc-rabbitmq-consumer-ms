package com.ms.parkingcontrol.adapters.out.parkingmanagement.database;

import com.ms.parkingcontrol.adapters.config.ParkingSpotNotFoundException;
import com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.adapters.out.parkingmanagement.ResearchedParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.FilteredParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;
import com.ms.parkingcontrol.ports.out.parkingmanagement.MongoParkingSpotDBOperationsPortOutbound;
import com.ms.parkingcontrol.ports.out.parkingmanagement.ParkingSpotStoreDatabasePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
class ParkingSpotStoreDatabase implements ParkingSpotStoreDatabasePortOutbound {

    @Autowired
    private MongoParkingSpotDBOperationsPortOutbound mongoParkingSpotDBOperationsPortOutbound;

    @Override
    public com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot saveParkingSpot(com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot parkingSpot) {
        ParkingSpot parkingSpotDocument = mongoParkingSpotDBOperationsPortOutbound.saveParkingSpot(parkingSpot);

        return buildParkingSpotEntity(parkingSpotDocument);
    }

    @Override
    public com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot getParkingSpot(String id) {
        Optional<ParkingSpot> parkingSpotOptional = mongoParkingSpotDBOperationsPortOutbound.getParkingSpot(id);

        if (!parkingSpotOptional.isPresent())
            throw new ParkingSpotNotFoundException("Parking spot not found.");

        return buildParkingSpotEntity(parkingSpotOptional.get());
    }

    @Override
    public FilteredParkingSpot getAllParkingSpots(ParkingSpotSearch parkingSpotSearch) {
        ResearchedParkingSpot parkingSpots = mongoParkingSpotDBOperationsPortOutbound.getAll(parkingSpotSearch);

        return buildParkingSpotsAggregate(parkingSpots);
    }

    private FilteredParkingSpot buildParkingSpotsAggregate(ResearchedParkingSpot parkingSpots) {

        List<com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot> parkingSpotList = new ArrayList<>();


        parkingSpots.getResult().forEach(parkingSpot ->
                parkingSpotList.add(buildParkingSpotEntity(parkingSpot))
        );

        return FilteredParkingSpot.builder()
                .withParkingSpots(parkingSpotList)
                .withTotal(parkingSpots.getTotal())
                .withTotalPages(parkingSpots.getTotalPages())
                .build();
    }

    @Override
    public String findByLicensePlateCar(String licensePlateCar) {
        ParkingSpot parkingSpot = mongoParkingSpotDBOperationsPortOutbound.searchByLicensePlateCar(licensePlateCar).orElse(new ParkingSpot());

        return parkingSpot.getLicensePlateCar();
    }

    @Override
    public String findByParkingSpotNumber(String parkingSpotNumber) {
        ParkingSpot parkingSpot = mongoParkingSpotDBOperationsPortOutbound.searchByParkingSpotNumber(parkingSpotNumber).orElse(new ParkingSpot());

        return parkingSpot.getParkingSpotNumber();
    }

    @Override
    public String findByApartment(String apartment) {
        ParkingSpot parkingSpot = mongoParkingSpotDBOperationsPortOutbound.searchByApartment(apartment).orElse(new ParkingSpot());

        return parkingSpot.getApartment();
    }

    @Override
    public String findByBlock(String block) {
        ParkingSpot parkingSpot = mongoParkingSpotDBOperationsPortOutbound.searchByBlock(block).orElse(new ParkingSpot());

        return parkingSpot.getBlock();
    }

    private com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot buildParkingSpotEntity(ParkingSpot parkingSpotDocument) {
        return com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot.builder()
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
    }
}

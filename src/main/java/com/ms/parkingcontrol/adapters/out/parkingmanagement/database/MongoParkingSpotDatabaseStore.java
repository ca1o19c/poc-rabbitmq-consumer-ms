package com.ms.parkingcontrol.adapters.out.parkingmanagement.database;

import com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.out.parkingmanagement.MongoDatabaseStorePortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
class MongoParkingSpotDatabaseStore implements MongoDatabaseStorePortOutbound {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ParkingSpot saveParkingSpot(com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot parkingSpot) {
        ParkingSpot parkingSpotDocument = new ParkingSpot();

        parkingSpotDocument.setId(parkingSpot.getId());
        parkingSpotDocument.setParkingSpotNumber(parkingSpot.getParkingSpotNumber());
        parkingSpotDocument.setLicensePlateCar(parkingSpot.getLicensePlateCar());
        parkingSpotDocument.setRegistrationDate(parkingSpot.getRegistrationDate());
        parkingSpotDocument.setApartment(parkingSpot.getApartment());
        parkingSpotDocument.setBlock(parkingSpot.getBlock());
        parkingSpotDocument.setBrandCar(parkingSpot.getBrandCar());
        parkingSpotDocument.setColorCar(parkingSpot.getColorCar());
        parkingSpotDocument.setModelCar(parkingSpot.getModelCar());
        parkingSpotDocument.setResponsibleName(parkingSpot.getResponsibleName());

        return mongoTemplate.save(parkingSpotDocument);
    }

    @Override
    public Optional<ParkingSpot> getParkingSpot(String id) {
        Query query = new Query(Criteria.where("id").is(id));

        return Optional.ofNullable(mongoTemplate.findOne(query, ParkingSpot.class));
    }

    @Override
    public Optional<ParkingSpot> searchByLicensePlateCar(String query) {
        Query builtQuery = new Query(Criteria.where("license_plate_car").is(query));

        return Optional.ofNullable(mongoTemplate.findOne(builtQuery, ParkingSpot.class));
    }

    @Override
    public Optional<ParkingSpot> searchByParkingSpotNumber(String parkingSpotNumber) {
        Query builtQuery = new Query(Criteria.where("parking_spot_number").is(parkingSpotNumber));

        return Optional.ofNullable(mongoTemplate.findOne(builtQuery, ParkingSpot.class));
    }

    @Override
    public Optional<ParkingSpot> searchByApartment(String apartment) {
        Query builtQuery = new Query(Criteria.where("apartment").is(apartment));

        return Optional.ofNullable(mongoTemplate.findOne(builtQuery, ParkingSpot.class));
    }

    @Override
    public Optional<ParkingSpot> searchByBlock(String block) {
        Query builtQuery = new Query(Criteria.where("block").is(block));

        return Optional.ofNullable(mongoTemplate.findOne(builtQuery, ParkingSpot.class));
    }
}

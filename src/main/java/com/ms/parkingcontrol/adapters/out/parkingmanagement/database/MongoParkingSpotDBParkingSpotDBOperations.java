package com.ms.parkingcontrol.adapters.out.parkingmanagement.database;

import com.ms.parkingcontrol.adapters.out.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.adapters.out.parkingmanagement.ResearchedParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;
import com.ms.parkingcontrol.domain.parkingmanagement.SortType;
import com.ms.parkingcontrol.ports.out.parkingmanagement.MongoParkingSpotDBOperationsPortOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Component
class MongoParkingSpotDBParkingSpotDBOperations implements MongoParkingSpotDBOperationsPortOutbound {

    private static final String REGISTRATION_DATE_PROPERTY = "registration_date";
    private static final String BRAND_CAR_PROPERTY = "brand_car";
    private static final String PARKING_SPOT_NUMBER_PROPERTY = "parking_spot_number";
    private static final String ID_PROPERTY = "id";

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
        Query query = new Query(Criteria.where(ID_PROPERTY).is(id));

        return Optional.ofNullable(mongoTemplate.findOne(query, ParkingSpot.class));
    }

    @Override
    public ResearchedParkingSpot getAll(ParkingSpotSearch parkingSpotSearch) {
        Query query = this.buildQuery(parkingSpotSearch);

        int page = parkingSpotSearch.getPage();

        int limit = parkingSpotSearch.getPerPage();

        int total = Math.toIntExact(mongoTemplate.count(query, ParkingSpot.class));

        int totalPages = total > limit ? Math.floorDiv(total, limit) : 1;

        Sort.Direction direction = Sort.Direction.fromString(
                isEmpty(parkingSpotSearch.getSortType()) ? SortType.ASC.getValue()
                        : parkingSpotSearch.getSortType().getValue());

        query.with(PageRequest.of(page, limit, Sort.by(direction, REGISTRATION_DATE_PROPERTY)));

        List<ParkingSpot> books = mongoTemplate.find(query, ParkingSpot.class);

        return new ResearchedParkingSpot(total, totalPages, books);
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

    private Query buildQuery(ParkingSpotSearch search) {
        Query query = new Query();

        Instant initialDate = toStartOfDay(search.getInitialDate());
        Instant finalDate = toEndOfDay(search.getFinalDate());

        if (!isNull(initialDate) && !isNull(finalDate))
            query.addCriteria(Criteria.where(REGISTRATION_DATE_PROPERTY).gte(initialDate).lte(finalDate));

        if (!isNull(initialDate) && isNull(finalDate))
            query.addCriteria(Criteria.where(REGISTRATION_DATE_PROPERTY).gte(initialDate));

        if (!isNull(finalDate) && isNull(initialDate))
            query.addCriteria(Criteria.where(REGISTRATION_DATE_PROPERTY).lte(finalDate));

        String brandCar = search.getBrandCar();

        if (!isNull(brandCar)) query.addCriteria(Criteria.where(BRAND_CAR_PROPERTY).is(brandCar));

        String parkingSpotNumber = search.getParkingSpotNumber();

        if (!isNull(parkingSpotNumber))
            query.addCriteria(Criteria.where(PARKING_SPOT_NUMBER_PROPERTY).is(parkingSpotNumber));

        return query;
    }

    private Instant toStartOfDay(LocalDate localDate) {
        return localDate == null ? null : localDate.atStartOfDay(ZoneId.of("UTC")).toInstant();
    }

    private Instant toEndOfDay(LocalDate localDate) {
        return localDate == null ? null : localDate.atTime(LocalTime.MAX).atZone(ZoneId.of("UTC")).toInstant();
    }
}

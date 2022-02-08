package com.ms.parkingcontrol.domain.parkingmanagement;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document("parking-spot")
public class ParkingSpot {

    private UUID id;
    private String parkingSpotNumber;
    private String licensePlateCar;
    private String brandCar;
    private String modelCar;
    private String colorCar;
    private LocalDateTime registrationDate;
    private String responsibleName;
    private String apartment;
    private String block;

    public UUID getId() {
        return id;
    }

    public ParkingSpot setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public ParkingSpot setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
        return this;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public ParkingSpot setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
        return this;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public ParkingSpot setBrandCar(String brandCar) {
        this.brandCar = brandCar;
        return this;
    }

    public String getModelCar() {
        return modelCar;
    }

    public ParkingSpot setModelCar(String modelCar) {
        this.modelCar = modelCar;
        return this;
    }

    public String getColorCar() {
        return colorCar;
    }

    public ParkingSpot setColorCar(String colorCar) {
        this.colorCar = colorCar;
        return this;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public ParkingSpot setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public ParkingSpot setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
        return this;
    }

    public String getApartment() {
        return apartment;
    }

    public ParkingSpot setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    public String getBlock() {
        return block;
    }

    public ParkingSpot setBlock(String block) {
        this.block = block;
        return this;
    }

    public void created() {
        this.setId(UUID.randomUUID());
        this.setRegistrationDate(LocalDateTime.now());
    }
}

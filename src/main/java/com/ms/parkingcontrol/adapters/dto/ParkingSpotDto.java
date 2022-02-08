package com.ms.parkingcontrol.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {
    @NotBlank
    @JsonProperty("parking_spot_number")
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    @JsonProperty("license_plate_car")
    private String licensePlateCar;

    @NotBlank
    @JsonProperty("brand_car")
    private String brandCar;

    @NotBlank
    @JsonProperty("model_car")
    private String modelCar;

    @NotBlank
    @JsonProperty("color_car")
    private String colorCar;

    @NotBlank
    @JsonProperty("responsible_name")
    private String responsibleName;

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public ParkingSpotDto setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
        return this;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public ParkingSpotDto setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
        return this;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public ParkingSpotDto setBrandCar(String brandCar) {
        this.brandCar = brandCar;
        return this;
    }

    public String getModelCar() {
        return modelCar;
    }

    public ParkingSpotDto setModelCar(String modelCar) {
        this.modelCar = modelCar;
        return this;
    }

    public String getColorCar() {
        return colorCar;
    }

    public ParkingSpotDto setColorCar(String colorCar) {
        this.colorCar = colorCar;
        return this;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public ParkingSpotDto setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
        return this;
    }

    public String getApartment() {
        return apartment;
    }

    public ParkingSpotDto setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    public String getBlock() {
        return block;
    }

    public ParkingSpotDto setBlock(String block) {
        this.block = block;
        return this;
    }
}

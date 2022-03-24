package com.ms.parkingcontrol.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotRequest {
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

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public String getBlock() {
        return block;
    }
}

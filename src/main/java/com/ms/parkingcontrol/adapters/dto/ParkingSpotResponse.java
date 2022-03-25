package com.ms.parkingcontrol.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingSpotResponse {
    private String id;
    @JsonProperty("parking_spot_number")
    private String parkingSpotNumber;
    @JsonProperty("license_plate_car")
    private String licensePlateCar;
    @JsonProperty("brand_car")
    private String brandCar;
    @JsonProperty("model_car")
    private String modelCar;
    @JsonProperty("color_car")
    private String colorCar;
    @JsonProperty("registration_date")
    private LocalDateTime registrationDate;
    @JsonProperty("responsible_name")
    private String responsibleName;
    private String apartment;
    private String block;

    public String getId() {
        return id;
    }

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String parkingSpotNumber;
        private String licensePlateCar;
        private String brandCar;
        private String modelCar;
        private String colorCar;
        private LocalDateTime registrationDate;
        private String responsibleName;
        private String apartment;
        private String block;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withParkingSpotNumber(String parkingSpotNumber) {
            this.parkingSpotNumber = parkingSpotNumber;
            return this;
        }

        public Builder withLicensePlateCar(String licensePlateCar) {
            this.licensePlateCar = licensePlateCar;
            return this;
        }

        public Builder withBrandCar(String brandCar) {
            this.brandCar = brandCar;
            return this;
        }

        public Builder withModelCar(String modelCar) {
            this.modelCar = modelCar;
            return this;
        }

        public Builder withColorCar(String colorCar) {
            this.colorCar = colorCar;
            return this;
        }

        public Builder withRegistrationDate(LocalDateTime localDateTime) {
            this.registrationDate = localDateTime;
            return this;
        }

        public Builder withResponsibleName(String responsibleName) {
            this.responsibleName = responsibleName;
            return this;
        }

        public Builder withApartment(String apartment) {
            this.apartment = apartment;
            return this;
        }

        public Builder withBlock(String block) {
            this.block = block;
            return this;
        }

        public ParkingSpotResponse build() {

            ParkingSpotResponse parkingSpotResponse = new ParkingSpotResponse();

            parkingSpotResponse.modelCar = this.modelCar;
            parkingSpotResponse.apartment = this.apartment;
            parkingSpotResponse.parkingSpotNumber = this.parkingSpotNumber;
            parkingSpotResponse.colorCar = this.colorCar;
            parkingSpotResponse.responsibleName = this.responsibleName;
            parkingSpotResponse.id = this.id;
            parkingSpotResponse.brandCar = this.brandCar;
            parkingSpotResponse.registrationDate = this.registrationDate;
            parkingSpotResponse.licensePlateCar = this.licensePlateCar;
            parkingSpotResponse.block = this.block;

            return parkingSpotResponse;
        }
    }

    public static ParkingSpotResponse from(ParkingSpot entity) {
        return ParkingSpotResponse.builder()
                .withId(entity.getId())
                .withParkingSpotNumber(entity.getParkingSpotNumber())
                .withApartment(entity.getApartment())
                .withBlock(entity.getBlock())
                .withBrandCar(entity.getBrandCar())
                .withColorCar(entity.getColorCar())
                .withLicensePlateCar(entity.getLicensePlateCar())
                .withModelCar(entity.getModelCar())
                .withResponsibleName(entity.getResponsibleName())
                .withRegistrationDate(entity.getRegistrationDate())
                .build();
    }
}

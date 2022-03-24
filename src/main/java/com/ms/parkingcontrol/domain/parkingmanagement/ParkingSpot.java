package com.ms.parkingcontrol.domain.parkingmanagement;

import java.time.LocalDateTime;
import java.util.UUID;

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

        public Builder withId() {
            this.id = UUID.randomUUID();
            return this;
        }

        public Builder withId(UUID id) {
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

        public Builder withRegistrationDate() {
            this.registrationDate = LocalDateTime.now();
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

        public ParkingSpot build() {
            ParkingSpot parkingSpot = new ParkingSpot();
            parkingSpot.brandCar = this.brandCar;
            parkingSpot.modelCar = this.modelCar;
            parkingSpot.apartment = this.apartment;
            parkingSpot.parkingSpotNumber = this.parkingSpotNumber;
            parkingSpot.colorCar = this.colorCar;
            parkingSpot.responsibleName = this.responsibleName;
            parkingSpot.id = this.id;
            parkingSpot.registrationDate = this.registrationDate;
            parkingSpot.licensePlateCar = this.licensePlateCar;
            parkingSpot.block = this.block;
            return parkingSpot;
        }
    }
}

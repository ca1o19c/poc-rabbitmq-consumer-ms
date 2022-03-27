package com.ms.parkingcontrol.domain.parkingmanagement;

import java.time.LocalDate;

public class ParkingSpotSearch {
    private String parkingSpotNumber;
    private String licensePlateCar;
    private String responsibleName;
    private String brandCar;
    private Integer page;
    private Integer perPage;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private SortType sortType;

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public SortType getSortType() {
        return sortType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String parkingSpotNumber;
        private String licensePlateCar;
        private String responsibleName;
        private String brandCar;
        private Integer page;
        private Integer perPage;
        private LocalDate initialDate;
        private LocalDate finalDate;
        private SortType sortType;

        public Builder withParkingSpotNumber(String parkingSpotNumber) {
            this.parkingSpotNumber = parkingSpotNumber;
            return this;
        }

        public Builder withLicensePlateCar(String licensePlateCar) {
            this.licensePlateCar = licensePlateCar;
            return this;
        }

        public Builder withResponsibleName(String responsibleName) {
            this.responsibleName = responsibleName;
            return this;
        }

        public Builder withBrandCar(String brandCar) {
            this.brandCar = brandCar;
            return this;
        }

        public Builder withPage(Integer page) {
            this.page = page;
            return this;
        }

        public Builder withPerPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder withInitialDate(LocalDate initialDate) {
            this.initialDate = initialDate;
            return this;
        }

        public Builder withFinalDate(LocalDate finalDate) {
            this.finalDate = finalDate;
            return this;
        }

        public Builder withSortType(SortType sortType) {
            this.sortType = sortType;
            return this;
        }

        public ParkingSpotSearch build() {
            ParkingSpotSearch parkingSpotSearch = new ParkingSpotSearch();
            parkingSpotSearch.parkingSpotNumber = this.parkingSpotNumber;
            parkingSpotSearch.brandCar = this.brandCar;
            parkingSpotSearch.sortType = this.sortType;
            parkingSpotSearch.perPage = this.perPage;
            parkingSpotSearch.responsibleName = this.responsibleName;
            parkingSpotSearch.licensePlateCar = this.licensePlateCar;
            parkingSpotSearch.finalDate = this.finalDate;
            parkingSpotSearch.page = this.page;
            parkingSpotSearch.initialDate = this.initialDate;
            return parkingSpotSearch;
        }
    }
}

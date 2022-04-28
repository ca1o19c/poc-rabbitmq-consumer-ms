package com.ms.parkingcontrol.adapters.outbound.parkingmanagement;

import java.util.List;

public class ResearchedParkingSpot {

    private final Integer total;

    private final Integer totalPages;

    private final List<ParkingSpot> result;

    public ResearchedParkingSpot(Integer total, Integer totalPages, List<ParkingSpot> result) {
        this.total = total;
        this.totalPages = totalPages;
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public List<ParkingSpot> getResult() {
        return result;
    }
}

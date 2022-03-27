package com.ms.parkingcontrol.adapters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"page", "per_page", "total", "data"})
public class PageResponse<ParkingSpotResponse> {

    private final Integer page;

    @JsonProperty("per_page")
    private final Integer perPage;

    private final Integer total;

    @JsonProperty("data")
    private final List<ParkingSpotResponse> parkingSpotResponses;


    public PageResponse(List<ParkingSpotResponse> books, Integer page, Integer perPage, Integer total) {
        this.parkingSpotResponses = books;
        this.page = page;
        this.perPage = perPage;
        this.total = total;
    }

    public List<ParkingSpotResponse> getParkingSpotResponses() {
        return parkingSpotResponses;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotal() {
        return total;
    }
}

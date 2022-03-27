package com.ms.parkingcontrol.adapters.in.parkingmanagement;

import com.ms.parkingcontrol.adapters.dto.PageResponse;
import com.ms.parkingcontrol.adapters.dto.ParkingSpotRequest;
import com.ms.parkingcontrol.adapters.dto.ParkingSpotResponse;
import com.ms.parkingcontrol.domain.parkingmanagement.FilteredParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;
import com.ms.parkingcontrol.domain.parkingmanagement.SortType;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotFacadePortInbound;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/v1/parking-spots")
@RestController
public class ParkingSpotController {

    @Autowired
    private ParkingSpotFacadePortInbound parkingSpotFacadePortInbound;

    @Autowired
    private ParkingSpotPortInbound parkingSpotPortInbound;


    @GetMapping
    public ResponseEntity<Object> getAllParkingSpots(@RequestParam(required = false, value = "parking_spot_number") String parkingSpotNumber,
                                                     @RequestParam(required = false, value = "license_plate_car") String licensePlateCar,
                                                     @RequestParam(required = false, value = "responsible_name") String responsibleName,
                                                     @RequestParam(required = false, value = "brand_car") String brandCar,
                                                     @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(value = "per_page", required = false, defaultValue = "50") Integer perPage,
                                                     @RequestParam(value = "dir", defaultValue = "asc", required = false) String sortType,
                                                     @RequestParam(value = "initial_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate initialDate,
                                                     @RequestParam(value = "final_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finalDate) {

        ParkingSpotSearch parkingSpotSearch = ParkingSpotSearch.builder()
                .withBrandCar(brandCar)
                .withParkingSpotNumber(parkingSpotNumber)
                .withPage(page)
                .withResponsibleName(responsibleName)
                .withLicensePlateCar(licensePlateCar)
                .withPerPage(perPage)
                .withSortType(SortType.fromValue(sortType))
                .withInitialDate(initialDate)
                .withFinalDate(finalDate)
                .build();


        FilteredParkingSpot filteredParkingSpot = parkingSpotPortInbound.getAllParkingSpots(parkingSpotSearch);

        List<ParkingSpotResponse> parkingSpotResponses = filteredParkingSpot.getParkingSpots()
                .stream()
                .map(ParkingSpotResponse::from)
                .collect(Collectors.toList());

        PageResponse<ParkingSpotResponse> parkingSpotResponsePage= new PageResponse<>(
                parkingSpotResponses, parkingSpotSearch.getPage(), parkingSpotSearch.getPerPage(), filteredParkingSpot.getTotal(), filteredParkingSpot.getTotalPages());

        return ResponseEntity.ok(parkingSpotResponsePage);
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@Valid @RequestBody ParkingSpotRequest parkingSpotRequest) {

        ParkingSpot parkingSpot = ParkingSpot.builder()
                .withId()
                .withParkingSpotNumber(parkingSpotRequest.getParkingSpotNumber())
                .withApartment(parkingSpotRequest.getApartment())
                .withBlock(parkingSpotRequest.getBlock())
                .withBrandCar(parkingSpotRequest.getBrandCar())
                .withColorCar(parkingSpotRequest.getColorCar())
                .withLicensePlateCar(parkingSpotRequest.getLicensePlateCar())
                .withModelCar(parkingSpotRequest.getModelCar())
                .withResponsibleName(parkingSpotRequest.getResponsibleName())
                .withRegistrationDate()
                .build();

        ParkingSpotResponse entity = ParkingSpotResponse
                .from(parkingSpotFacadePortInbound.saveParkingSpotFacade(parkingSpot));

        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getParkingSpot(@PathVariable String id) {
        ParkingSpotResponse entity = ParkingSpotResponse
                .from(parkingSpotPortInbound.getParkingSpot(id));

        return ResponseEntity.ok(entity);
    }
}

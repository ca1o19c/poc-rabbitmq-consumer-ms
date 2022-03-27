package com.ms.parkingcontrol.adapters.in.parkingmanagement;

import com.ms.parkingcontrol.adapters.dto.PageResponse;
import com.ms.parkingcontrol.adapters.dto.ParkingSpotRequest;
import com.ms.parkingcontrol.adapters.dto.ParkingSpotResponse;
import com.ms.parkingcontrol.domain.parkingmanagement.FilteredParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpotSearch;
import com.ms.parkingcontrol.domain.parkingmanagement.SortType;
import com.ms.parkingcontrol.ports.in.parkingmanagement.MongoOperationsPortInbound;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotFacadePortInbound;
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
    private ParkingSpotFacadePortInbound parkingSpotPortInbound;

    @Autowired
    private MongoOperationsPortInbound mongoOperationsPortInbound;


    @GetMapping
    public ResponseEntity<Object> getAllParkingSpots(@RequestParam(required = false) String parkingSpotNumber, @RequestParam(required = false) String licensePlateCar,
                                                     @RequestParam(required = false) String responsibleName, @RequestParam(required = false) String brandCar,
                                                     @RequestParam Integer page, @RequestParam Integer perPage,
                                                     @RequestParam(value = "sort_type", defaultValue = "asc", required = false) String sortType,
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


        FilteredParkingSpot filteredParkingSpot = mongoOperationsPortInbound.getAllParkingSpots(parkingSpotSearch);

        List<ParkingSpotResponse> parkingSpotResponses = filteredParkingSpot.getParkingSpots()
                .stream()
                .map(ParkingSpotResponse::from)
                .collect(Collectors.toList());

        PageResponse<ParkingSpotResponse> parkingSpotResponsePage= new PageResponse<>(
                parkingSpotResponses, parkingSpotSearch.getPage(), parkingSpotSearch.getPerPage(), filteredParkingSpot.getTotal()
        );

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
                .from(parkingSpotPortInbound.saveParkingSpotFacade(parkingSpot));

        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getParkingSpot(@PathVariable String id) {
        ParkingSpotResponse entity = ParkingSpotResponse
                .from(mongoOperationsPortInbound.getParkingSpot(id));

        return ResponseEntity.ok(entity);
    }
}

package com.ms.parkingcontrol.adapters.in.parkingmanagement;

import com.ms.parkingcontrol.adapters.dto.ParkingSpotRequest;
import com.ms.parkingcontrol.adapters.dto.ParkingSpotResponse;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortInbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/parking-spots")
@RestController
public class ParkingSpotControllerImpl implements ParkingSpotController {

    @Autowired
    private ParkingSpotPortInbound parkingSpotPortInbound;

    @Override
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody ParkingSpotRequest parkingSpotRequest) {

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
}

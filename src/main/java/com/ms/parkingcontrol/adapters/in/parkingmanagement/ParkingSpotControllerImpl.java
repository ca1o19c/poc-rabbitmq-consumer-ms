package com.ms.parkingcontrol.adapters.in.parkingmanagement;

import com.ms.parkingcontrol.adapters.dto.ParkingSpotDto;
import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import com.ms.parkingcontrol.ports.in.parkingmanagement.ParkingSpotPortIn;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RequestMapping("v1/parking-spots")
@RestController
public class ParkingSpotControllerImpl implements ParkingSpotController{

    @Autowired
    private ParkingSpotPortIn parkingSpotPortIn;

    @Override
    @PostMapping
    public ResponseEntity<Void> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        var parkingSpot = new ParkingSpot();

        BeanUtils.copyProperties(parkingSpotDto, parkingSpot);

        var entity = this.parkingSpotPortIn.saveParkingSpot(parkingSpot);

        return ResponseEntity.created(this.buildLocation(entity.getId())).build();
    }

    private URI buildLocation(UUID id) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("v1/parking-spots/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}

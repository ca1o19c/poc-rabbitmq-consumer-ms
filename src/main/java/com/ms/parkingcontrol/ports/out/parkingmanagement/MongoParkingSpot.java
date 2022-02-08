package com.ms.parkingcontrol.ports.out.parkingmanagement;

import com.ms.parkingcontrol.domain.parkingmanagement.ParkingSpot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoParkingSpot extends MongoRepository<ParkingSpot, UUID> {
}

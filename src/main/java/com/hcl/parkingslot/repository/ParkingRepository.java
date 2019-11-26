package com.hcl.parkingslot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkingslot.entity.Parking;
@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
	
	Optional<Parking> findByParkingSlotName(String parkingSlotName);


}

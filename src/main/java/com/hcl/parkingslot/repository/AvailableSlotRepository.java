package com.hcl.parkingslot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkingslot.entity.AvailableSlot;


@Repository
public interface AvailableSlotRepository extends JpaRepository<AvailableSlot, Integer>{
	
	Optional<AvailableSlot> findByAvailableSlotId(Integer availableSlotId);
	
	Optional<AvailableSlot> findBySapId(Integer sapId);

}

package com.hcl.parkingslot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.parkingslot.entity.EmployeeSpot;

public interface EmployeeSpotRepository extends JpaRepository<EmployeeSpot, Integer>{

	Optional<EmployeeSpot> findBySapId(Integer sapId);
}

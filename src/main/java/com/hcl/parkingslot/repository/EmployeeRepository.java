package com.hcl.parkingslot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkingslot.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Employee findBySapIDAndEmpExp(Integer sapId, float empExperience); 
	
	Optional<Employee> findByMobileNo(Long mobileNo);
	Optional<Employee> findBySapId(Integer sapId);
}

package com.hcl.parkingslot.service;

import com.hcl.parkingslot.dto.EmployeeRequestDto;
import com.hcl.parkingslot.dto.EmployeeResponseDto;

public interface EmployeeService {
	
	EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) throws Exception;

}

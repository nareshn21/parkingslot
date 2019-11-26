package com.hcl.parkingslot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingslot.dto.EmployeeRequestDto;
import com.hcl.parkingslot.dto.EmployeeResponseDto;
import com.hcl.parkingslot.entity.Employee;
import com.hcl.parkingslot.exception.ParkingSlotException;
import com.hcl.parkingslot.repository.EmployeeRepository;
import com.hcl.parkingslot.util.ParkingConstants;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empoyeeRepository;
	
	@Override
	public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) throws ParkingSlotException {
		EmployeeResponseDto employeeResponseDto=null;
		Employee emp=new Employee();
		 BeanUtils.copyProperties(employeeRequestDto, emp);
		 empoyeeRepository.save(emp);
		 
		 if(emp!=null) {
			 employeeResponseDto=new EmployeeResponseDto();
		 employeeResponseDto.setMessage(ParkingConstants.SUCCESS_EMPLOYEE);
		 employeeResponseDto.setStatus(201);
			}
	return employeeResponseDto ;
	
	}

}

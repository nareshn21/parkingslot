package com.hcl.parkingslot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parkingslot.dto.EmployeeRequestDto;
import com.hcl.parkingslot.dto.EmployeeResponseDto;
import com.hcl.parkingslot.dto.LoginDto;
import com.hcl.parkingslot.dto.LoginResponseDto;
import com.hcl.parkingslot.service.EmployeeService;
import com.hcl.parkingslot.service.LoginService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	LoginService loginService;
	
	@PostMapping("/employees")
	EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) throws Exception {
		EmployeeResponseDto employeeResponseDto=employeeService.save(employeeRequestDto);
		employeeResponseDto=new EmployeeResponseDto();
		employeeResponseDto.setMessage("created");
		employeeResponseDto.setStatus(201);
		
		return employeeResponseDto;
	}
	@PostMapping("/login")
	LoginResponseDto login(LoginDto loginDto) throws Exception {
		LoginResponseDto loginResponseDto=loginService.login(loginDto);
		return loginResponseDto;
		
	}
}

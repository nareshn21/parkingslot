package com.hcl.parkingslot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingslot.dto.LoginDto;
import com.hcl.parkingslot.dto.LoginResponseDto;
import com.hcl.parkingslot.entity.Employee;
import com.hcl.parkingslot.repository.EmployeeRepository;

@Service
public class LoginServiceImpl implements LoginService{
@Autowired
EmployeeRepository employeeRepository;
	@Override
	public LoginResponseDto login(LoginDto loginDto) throws Exception {
		LoginResponseDto loginResponseDto=null;
		Optional<Employee> employee=employeeRepository.findByMobileNo(loginDto.getMobileNo());
		if(employee.isPresent()) {
			if(employee.get().getMobileNo().equals(loginDto.getMobileNo()) &&employee.get().getPassword().equals(loginDto.getPassword())) {
				loginResponseDto=new LoginResponseDto();
				loginResponseDto.setSapId(employee.get().getSapId());
				loginResponseDto.setMessage("Login success");
				loginResponseDto.setStatus(201);
				
			}else
				throw new Exception("invalidCredintial");
		}else
			throw new Exception("user not present");
		return loginResponseDto;
	}

}

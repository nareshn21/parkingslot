package com.hcl.parkingslot.service;

import java.util.List;

import com.hcl.parkingslot.dto.ApprovedResponseDto;
import com.hcl.parkingslot.dto.AvilableSlotsDto;
import com.hcl.parkingslot.dto.EmployeeSpotDto;
import com.hcl.parkingslot.dto.EmployeeSpotResponseDto;
import com.hcl.parkingslot.dto.RequestSlotDto;
import com.hcl.parkingslot.dto.RequestSlotResponseDto;

public interface ParkingService {
	
	//EmployeeSpotResponseDto allocateSlot(EmployeeSpotDto parkingRequestDto) throws Exception;

	EmployeeSpotResponseDto setEmployeeSpot(EmployeeSpotDto employeeSpotDto) throws Exception;
	List<AvilableSlotsDto> showAvailableSltos() throws Exception;
	RequestSlotResponseDto requestSlot(RequestSlotDto requestSlotDto) throws Exception;
	
	ApprovedResponseDto doraffles();


}

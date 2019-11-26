package com.hcl.parkingslot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.parkingslot.dto.AvilableSlotsDto;
import com.hcl.parkingslot.dto.EmployeeSpotDto;
import com.hcl.parkingslot.dto.EmployeeSpotResponseDto;
import com.hcl.parkingslot.dto.ReleaseDto;
import com.hcl.parkingslot.dto.ReleaseResponseDto;
import com.hcl.parkingslot.dto.RequestSlotDto;
import com.hcl.parkingslot.dto.RequestSlotResponseDto;
import com.hcl.parkingslot.service.ParkingService;
import com.hcl.parkingslot.service.ReleaseSlotService;

@RestController
@RequestMapping("/slots")
public class ParkingSlotController {
	@Autowired
	ParkingService parkingService;
	@Autowired
	ReleaseSlotService releaseSlotService;
	
	@PostMapping("/empspots")
	EmployeeSpotResponseDto setEmployeeSpot(EmployeeSpotDto employeeSpotDto) throws Exception {
		EmployeeSpotResponseDto employSot=parkingService.setEmployeeSpot(employeeSpotDto);
		return employSot;
	}
	@PostMapping("/releases")
	ReleaseResponseDto releaseSpot(ReleaseDto releaseDto) throws Exception {
		ReleaseResponseDto releaseResponseDto=releaseSlotService.releaseSpot(releaseDto);
		return releaseResponseDto;
	}
	@GetMapping("available")
	List<AvilableSlotsDto> showAvailableSltos() throws Exception {
		List<AvilableSlotsDto> avialbleSlots=parkingService.showAvailableSltos();
		return avialbleSlots;
	}
	@PostMapping("requestSots")
	RequestSlotResponseDto requestSlot(RequestSlotDto requestSlotDto) throws Exception{
		RequestSlotResponseDto requestSlotsResponseDto=parkingService.requestSlot(requestSlotDto);
		return requestSlotsResponseDto;
	}

}

package com.hcl.parkingslot.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingslot.dto.ReleaseDto;
import com.hcl.parkingslot.dto.ReleaseResponseDto;
import com.hcl.parkingslot.entity.AvailableSlot;
import com.hcl.parkingslot.entity.EmployeeSpot;
import com.hcl.parkingslot.repository.AvailableSlotRepository;
import com.hcl.parkingslot.repository.EmployeeSpotRepository;

@Service
public class ReleaseSlotServiceImpl implements ReleaseSlotService{
@Autowired
EmployeeSpotRepository employeeSpotRepository;
@Autowired
AvailableSlotRepository availableSlotRepository;
	@Override
	public ReleaseResponseDto releaseSpot(ReleaseDto releaseDto) throws Exception {
		ReleaseResponseDto releaseSpot=null;
		Optional<EmployeeSpot> empSpots=employeeSpotRepository.findBySapId(releaseDto.getSapId());
		if(empSpots.isPresent()) {
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			Optional<AvailableSlot> slotId=availableSlotRepository.findBySapId(releaseDto.getSapId());
			if(!slotId.isPresent()) {
			releaseSpot=new ReleaseResponseDto();
			AvailableSlot avialSlots=new AvailableSlot();
			avialSlots.setEmpSpotId(empSpots.get().getEmpSpotId());
			avialSlots.setReleaseDate(LocalDate.parse(releaseDto.getReleaseFromDate(), formatter).plusDays(releaseDto.getReleaseDays()));
			avialSlots.setSapId(empSpots.get().getSapId());
			availableSlotRepository.save(avialSlots);
		BeanUtils.copyProperties(avialSlots, releaseSpot);
		//treleaseSpot.setReleaseToDate(LocalDate.parse(releaseDto.getReleaseFromDate(), formatter.plus(releaseDto.getReleaseDays())));
		releaseSpot.setMessage("released slot successfully");
		releaseSpot.setStatus(201);
		}else 
			throw new Exception("you have already released the spot");
		
	}else
		throw new Exception("spot owner doesn't exit");
		return releaseSpot;
	}

}

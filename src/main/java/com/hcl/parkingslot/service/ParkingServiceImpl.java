package com.hcl.parkingslot.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkingslot.dto.ApprovedResponseDto;
import com.hcl.parkingslot.dto.AvilableSlotsDto;
import com.hcl.parkingslot.dto.EmployeeSpotDto;
import com.hcl.parkingslot.dto.EmployeeSpotResponseDto;
import com.hcl.parkingslot.dto.RequestSlotDto;
import com.hcl.parkingslot.dto.RequestSlotResponseDto;
import com.hcl.parkingslot.entity.AvailableSlot;
import com.hcl.parkingslot.entity.Employee;
import com.hcl.parkingslot.entity.EmployeeSpot;
import com.hcl.parkingslot.entity.Parking;
import com.hcl.parkingslot.entity.RequestSlot;
import com.hcl.parkingslot.repository.AvailableSlotRepository;
import com.hcl.parkingslot.repository.EmployeeRepository;
import com.hcl.parkingslot.repository.EmployeeSpotRepository;
import com.hcl.parkingslot.repository.ParkingRepository;
import com.hcl.parkingslot.repository.RequestSlotRepository;

@Service
public class ParkingServiceImpl implements ParkingService {
	@Autowired
	ParkingRepository parkingRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeSpotRepository employeeSpotRepository;
	@Autowired
	AvailableSlotRepository availableRepository;
	@Autowired
	RequestSlotRepository requestSlotsRepository;
	@Override
	
	public EmployeeSpotResponseDto setEmployeeSpot(EmployeeSpotDto employeeSpotDto) throws Exception {
		EmployeeSpotResponseDto employeeResponseDto=null;
		Optional<Employee> emp=employeeRepository.findBySapId(employeeSpotDto.getSapId());
		if(emp.isPresent()) {
			if(emp.get().getEmpExperience()>=15) {
				Optional<Parking> parking=parkingRepository.findByParkingSlotName(employeeSpotDto.getParkingSlotName());
				if(parking.isPresent()){
					if(parking.get().getStatus().equalsIgnoreCase("Available")) {
						Optional<EmployeeSpot> empspot=employeeSpotRepository.findBySapId(employeeSpotDto.getSapId());
						if(!empspot.isPresent()) {
						employeeResponseDto=new EmployeeSpotResponseDto();
						EmployeeSpot spot=new EmployeeSpot();
						spot.setSapId(emp.get().getSapId());
						spot.setParkingId(parking.get().getParkingId());
						employeeSpotRepository.save(spot);
						BeanUtils.copyProperties(spot, employeeResponseDto);
						employeeResponseDto.setParkingSlotName(parking.get().getParkingSlotName());
						employeeResponseDto.setMessage("employee spot has been created");
						employeeResponseDto.setStatus(201);
						return employeeResponseDto;
						}else 
							throw new Exception("spot owner already present ");
					}else
						throw new Exception("parking slot unavlaible ");
				}else
					throw new Exception("doesn't exit the slot name");
		}else
			throw new Exception("employee not eligible for a spot owner");
		
		
	}else
		throw new Exception("employee not found");
		
	}
	@Override
	public List<AvilableSlotsDto> showAvailableSltos() throws Exception {
		AvilableSlotsDto availSlots=null;
		/*
		 * Optional<AvailableSlot>
		 * avialSltos=availableRepository.findByAvailableSlotId(availableSltosDto.
		 * getAvailableSlotId());
		 */
	/*	if(avialSltos.isPresent()) {*/
			
			List<AvailableSlot> listOfSots=availableRepository.findAll();
			List<AvilableSlotsDto> availSlotsDto=new ArrayList<>();
			for (AvailableSlot availableSlots : listOfSots) {
			 availSlots=new AvilableSlotsDto();
			BeanUtils.copyProperties(availableSlots, availSlots);
			availSlotsDto.add(availSlots);
			}
		/*
		 * availSlots.setMessage("list of Avilable slots"); availSlots.setStatus(201);
		 */
		/*
		 * }else { throw new Exception("slots unavailable"); }
		 */
		return availSlotsDto;
	}
	@Override
	public RequestSlotResponseDto requestSlot(RequestSlotDto requestSlotDto) throws Exception {
		RequestSlotResponseDto requestSlotResponseDto=null;
		Optional<AvailableSlot> avialSltos=availableRepository.findByAvailableSlotId(requestSlotDto.getAvailbleSlotId());
		if(avialSltos.isPresent()) {
			Optional<RequestSlot> requestSlots=requestSlotsRepository.findBySapId(requestSlotDto.getSapId());
			if(!requestSlots.isPresent()) {
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
			requestSlotResponseDto=new RequestSlotResponseDto();
			RequestSlot reqSlots=new RequestSlot();
			reqSlots.setAvailableSlotId(avialSltos.get().getAvailableSlotId());
			reqSlots.setRequestFromDate(LocalDate.parse(requestSlotDto.getRequestFromDate(), formatter));
			reqSlots.setRequestToDate(LocalDate.parse(requestSlotDto.getRequestToDate(), formatter));
			reqSlots.setSapId(requestSlotDto.getSapId());
			reqSlots.setStatusSlot("pending");
			requestSlotsRepository.save(reqSlots);
			BeanUtils.copyProperties(reqSlots, requestSlotResponseDto);
			requestSlotResponseDto.setMessage("your slot request has been generated");
			requestSlotResponseDto.setStatus(201);
			}else 
				throw new Exception("this sap id has already requested slot");
			return requestSlotResponseDto;
		}else
			throw new Exception("there is no avialble slots");
		
	}
	@Override
	public ApprovedResponseDto doraffles() {
		/*List<RequestSlot> requestSlotList = requestSlotRepository.findByRequestDate(LocalDate.now().plusDays(1));
		List<AvailableSlot> availableSlotsList = availableSlotRepository
				.findByAvailableDate(LocalDate.now().plusDays(1));
		for (int i = 0; i < availableSlotsList.size(); i++) {
			for (int j = 0; j < requestSlotList.size(); j++) {
				int randomIndex = random.nextInt(requestSlotList.size() - 1);

				int registrationId = requestSlotList.get(randomIndex).getRegistrationId();

				availableSlotsList.get(randomIndex).setBookedEmpId(registrationId);
				availableSlotsList.get(randomIndex).setStatus("booked");

				availableSlotRepository.save(availableSlotsList.get(randomIndex));

			}*/
		return null;

	}
	
}

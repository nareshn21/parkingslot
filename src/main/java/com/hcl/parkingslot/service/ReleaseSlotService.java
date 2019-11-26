package com.hcl.parkingslot.service;

import com.hcl.parkingslot.dto.ReleaseDto;
import com.hcl.parkingslot.dto.ReleaseResponseDto;

public interface ReleaseSlotService {

	ReleaseResponseDto releaseSpot(ReleaseDto releaseDto) throws Exception;
}

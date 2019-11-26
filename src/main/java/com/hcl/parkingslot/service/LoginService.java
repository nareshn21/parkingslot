package com.hcl.parkingslot.service;

import com.hcl.parkingslot.dto.LoginDto;
import com.hcl.parkingslot.dto.LoginResponseDto;
import com.hcl.parkingslot.exception.ParkingSlotException;

public interface LoginService {
LoginResponseDto login(LoginDto loginDto) throws ParkingSlotException, Exception;
}

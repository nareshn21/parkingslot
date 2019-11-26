package com.hcl.parkingslot.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ParkingSlotException extends Exception {

	private String message;
	private static final long serialVersionUID = 1L;
	public ParkingSlotException(String message) {
		super(message);

}
}

package com.hcl.parkingslot.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeSpotResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer parkingId;
	private String parkingSlotName;
	private Integer sapId;
	private String message;
	private Integer status;
	

}

package com.hcl.parkingslot.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSpotDto implements Serializable {
	private static final long serialVersionUID = 1L;
private Integer sapId;
private String parkingSlotName;

}

package com.hcl.parkingslot.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSlotResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer sapId;
	private Integer AvailableSlotId;
	private LocalDate requestFromDate;
	private LocalDate requestToDate;
	private String statusSlot;
	private String message;
	private Integer status;
}

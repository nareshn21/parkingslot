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
public class AvilableSlotsDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer availableSlotId;
	private Integer empSpotId;
	private LocalDate releaseDate;
	private Integer sapId;
	/*
	 * private String message; private Integer status;
	 */

}

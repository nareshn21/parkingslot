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
public class ReleaseResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer sapId;
	private Integer empSpotId;
	private LocalDate releaseFromDate;
	private LocalDate releaseToDate;
	private String message;
	private Integer status;

}

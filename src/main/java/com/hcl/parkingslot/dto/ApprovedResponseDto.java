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
public class ApprovedResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
 private Integer availableId;
 private Integer sapId;
 private Integer requestSlotId;
 private LocalDate requestFromDate;
 private LocalDate requestToDate;
 private LocalDate statusSlot;
 private String message;
 private Integer status;
 
}

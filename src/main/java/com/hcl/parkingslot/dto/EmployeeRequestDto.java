package com.hcl.parkingslot.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String empName;
	private String password;
	private String empEmail;
	private Date empJoiningdate;
	private float empExperience;
	private String empDesignation;
	private Long mobileNo;
}

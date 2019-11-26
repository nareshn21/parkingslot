package com.hcl.parkingslot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="parking_details")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parkingId;
	private String parkingSlotName;
	private String status;
}

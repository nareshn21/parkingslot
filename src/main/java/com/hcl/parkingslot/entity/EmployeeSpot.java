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
@Table(name="employee_spot")
public class EmployeeSpot {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer empSpotId;
private Integer sapId;
private Integer parkingId;
}

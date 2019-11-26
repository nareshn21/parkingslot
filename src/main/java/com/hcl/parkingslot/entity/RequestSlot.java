package com.hcl.parkingslot.entity;

import java.time.LocalDate;

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
@Table(name="request_slots")
public class RequestSlot{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer requestSlotId;
private Integer sapId;
private Integer availableSlotId;
private LocalDate requestFromDate;
private LocalDate requestToDate;
private String statusSlot;
}

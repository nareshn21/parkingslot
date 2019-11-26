package com.hcl.parkingslot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkingslot.entity.RequestSlot;
@Repository
public interface RequestSlotRepository extends JpaRepository<RequestSlot, Integer>{
Optional<RequestSlot> findBySapId(Integer sapId);
}

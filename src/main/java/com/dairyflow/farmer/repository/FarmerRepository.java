package com.dairyflow.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairyflow.farmer.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
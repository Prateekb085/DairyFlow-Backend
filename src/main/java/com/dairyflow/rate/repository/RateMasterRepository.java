package com.dairyflow.rate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairyflow.rate.entity.RateMaster;

@Repository
public interface RateMasterRepository extends JpaRepository<RateMaster, Long> {

    Optional<RateMaster> findByMilkTypeAndFat(String milkType, Double fat);

}

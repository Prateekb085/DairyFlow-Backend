package com.dairyflow.rate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.rate.entity.RateMaster;
import com.dairyflow.rate.repository.RateMasterRepository;

@Service
public class RateMasterService {

    @Autowired
    private RateMasterRepository rateMasterRepository;

    // Add Rate
    public RateMaster addRate(RateMaster rateMaster) {
        return rateMasterRepository.save(rateMaster);
    }

    // Get All Rates
    public List<RateMaster> getAllRates() {
        return rateMasterRepository.findAll();
    }

    // Find Rate
    public RateMaster getRate(String milkType, Double fat) {
        return rateMasterRepository
                .findByMilkTypeAndFat(milkType, fat)
                .orElseThrow(() -> new RuntimeException("Rate not found"));
    }
}
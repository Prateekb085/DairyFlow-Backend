package com.dairyflow.farmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.farmer.entity.Farmer;
import com.dairyflow.farmer.repository.FarmerRepository;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    // Add Farmer
    public Farmer addFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    // Get All Farmers
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    // Get Farmer By ID
    public Farmer getFarmerById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
    }

    // Update Farmer
    public Farmer updateFarmer(Long id, Farmer farmer) {

        Farmer existingFarmer = farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        existingFarmer.setFarmerName(farmer.getFarmerName());
        existingFarmer.setFarmerCode(farmer.getFarmerCode());
        existingFarmer.setMobileNumber(farmer.getMobileNumber());
        existingFarmer.setVillage(farmer.getVillage());

        return farmerRepository.save(existingFarmer);
    }

    // Delete Farmer
    public String deleteFarmer(Long id) {

        farmerRepository.deleteById(id);

        return "Farmer Deleted Successfully";
    }
}
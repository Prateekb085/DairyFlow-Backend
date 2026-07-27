package com.dairyflow.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dairyflow.farmer.entity.Farmer;
import com.dairyflow.farmer.service.FarmerService;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    // Add Farmer
    @PostMapping
    public Farmer addFarmer(@RequestBody Farmer farmer) {
        return farmerService.addFarmer(farmer);
    }

    // Get All Farmers
    @GetMapping
    public List<Farmer> getAllFarmers() {
        return farmerService.getAllFarmers();
    }

    // Get Farmer By ID
    @GetMapping("/{id}")
    public Farmer getFarmerById(@PathVariable Long id) {
        return farmerService.getFarmerById(id);
    }

    // Update Farmer
    @PutMapping("/{id}")
    public Farmer updateFarmer(@PathVariable Long id,
                               @RequestBody Farmer farmer) {
        return farmerService.updateFarmer(id, farmer);
    }

    // Delete Farmer
    @DeleteMapping("/{id}")
    public String deleteFarmer(@PathVariable Long id) {
        return farmerService.deleteFarmer(id);
    }
}
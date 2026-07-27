package com.dairyflow.milk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.farmer.entity.Farmer;
import com.dairyflow.farmer.repository.FarmerRepository;
import com.dairyflow.milk.entity.MilkEntry;
import com.dairyflow.milk.repository.MilkEntryRepository;

@Service
public class MilkEntryService {

    @Autowired
    private MilkEntryRepository milkEntryRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    public MilkEntry addMilkEntry(MilkEntry milkEntry) {

        Farmer farmer = farmerRepository.findById(
                milkEntry.getFarmer().getId())
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        milkEntry.setFarmer(farmer);

        // Automatic amount calculation
        double total = milkEntry.getQuantity() * milkEntry.getRatePerLiter();
        milkEntry.setTotalAmount(total);

        return milkEntryRepository.save(milkEntry);
    }

    public List<MilkEntry> getAllMilkEntries() {
        return milkEntryRepository.findAll();
    }
}
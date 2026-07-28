package com.dairyflow.milk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.farmer.entity.Farmer;
import com.dairyflow.farmer.repository.FarmerRepository;
import com.dairyflow.milk.entity.MilkEntry;
import com.dairyflow.milk.repository.MilkEntryRepository;
import com.dairyflow.rate.entity.RateMaster;
import com.dairyflow.rate.repository.RateMasterRepository;

@Service
public class MilkEntryService {

    @Autowired
    private MilkEntryRepository milkEntryRepository;

    @Autowired
    private FarmerRepository farmerRepository;
    
    @Autowired
    private RateMasterRepository rateMasterRepository;

    public MilkEntry addMilkEntry(MilkEntry milkEntry) {

        Farmer farmer = farmerRepository.findById(milkEntry.getFarmer().getId())
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        milkEntry.setFarmer(farmer);

        // Find rate from Rate Master
        RateMaster rate = rateMasterRepository
                .findByMilkTypeAndFat(
                        milkEntry.getMilkType(),
                        milkEntry.getFat())
                .orElseThrow(() -> new RuntimeException("Rate not found"));

        // Set rate automatically
        milkEntry.setRatePerLiter(rate.getRatePerLiter());

        // Calculate total amount
        double total = milkEntry.getQuantity() * rate.getRatePerLiter();

        milkEntry.setTotalAmount(total);

        return milkEntryRepository.save(milkEntry);
    }

    public List<MilkEntry> getAllMilkEntries() {
        return milkEntryRepository.findAll();
    }
}
package com.dairyflow.milk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.farmer.entity.Farmer;
import com.dairyflow.farmer.repository.FarmerRepository;
import com.dairyflow.milk.entity.MilkEntry;
import com.dairyflow.milk.repository.MilkEntryRepository;
import com.dairyflow.rate.entity.RateMaster;
import com.dairyflow.rate.repository.RateMasterRepository;
import com.dairyflow.common.exception.DuplicateMilkEntryException;

@Service
public class MilkEntryService {

    @Autowired
    private MilkEntryRepository milkEntryRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private RateMasterRepository rateMasterRepository;

    public MilkEntry addMilkEntry(MilkEntry milkEntry) {

        // Find Farmer
        Farmer farmer = farmerRepository.findById(milkEntry.getFarmer().getId())
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        milkEntry.setFarmer(farmer);

        // Check Duplicate Entry
        Optional<MilkEntry> existingEntry =
                milkEntryRepository.findByFarmerIdAndCollectionDateAndShift(
                        farmer.getId(),
                        milkEntry.getCollectionDate(),
                        milkEntry.getShift());

        if (existingEntry.isPresent()) {
            throw new DuplicateMilkEntryException(
                    "Milk entry already exists for this farmer, date, and shift.");
        }

        // Find Rate from Rate Master
        RateMaster rate = rateMasterRepository
                .findByMilkTypeAndFat(
                        milkEntry.getMilkType(),
                        milkEntry.getFat())
                .orElseThrow(() -> new RuntimeException("Rate not found"));

        // Set Rate Automatically
        milkEntry.setRatePerLiter(rate.getRatePerLiter());

        // Calculate Total Amount
        double total = milkEntry.getQuantity() * rate.getRatePerLiter();
        milkEntry.setTotalAmount(total);

        // Save Entry
        return milkEntryRepository.save(milkEntry);
    }

    // Get All Milk Entries
    public List<MilkEntry> getAllMilkEntries() {
        return milkEntryRepository.findAll();
    }
 // Update Milk Entry
    public MilkEntry updateMilkEntry(Long id, MilkEntry milkEntry) {

        MilkEntry existing = milkEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Milk Entry Not Found"));

        Farmer farmer = farmerRepository.findById(milkEntry.getFarmer().getId())
                .orElseThrow(() -> new RuntimeException("Farmer Not Found"));

        existing.setFarmer(farmer);
        existing.setCollectionDate(milkEntry.getCollectionDate());
        existing.setShift(milkEntry.getShift());
        existing.setMilkType(milkEntry.getMilkType());
        existing.setQuantity(milkEntry.getQuantity());
        existing.setFat(milkEntry.getFat());

        // Get Rate Automatically
        System.out.println("Milk Type = [" + milkEntry.getMilkType() + "]");
        System.out.println("Fat = [" + milkEntry.getFat() + "]");

        Optional<RateMaster> rateOptional =
                rateMasterRepository.findByMilkTypeAndFat(
                        milkEntry.getMilkType(),
                        milkEntry.getFat());

        System.out.println("Rate Found = " + rateOptional.isPresent());

        RateMaster rate = rateOptional.orElseThrow(
                () -> new RuntimeException("Rate Not Found"));

        existing.setRatePerLiter(rate.getRatePerLiter());

        existing.setTotalAmount(
                existing.getQuantity() * rate.getRatePerLiter());

        return milkEntryRepository.save(existing);
    }

    // Delete Milk Entry
    public String deleteMilkEntry(Long id) {

        milkEntryRepository.deleteById(id);

        return "Milk Entry Deleted Successfully";
    }
}
package com.dairyflow.milk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dairyflow.milk.entity.MilkEntry;
import com.dairyflow.milk.service.MilkEntryService;

@RestController
@RequestMapping("/api/milk")
public class MilkEntryController {

    @Autowired
    private MilkEntryService milkEntryService;

    @PostMapping
    public MilkEntry addMilkEntry(@RequestBody MilkEntry milkEntry) {
        return milkEntryService.addMilkEntry(milkEntry);
    }

    @GetMapping
    public List<MilkEntry> getAllMilkEntries() {
        return milkEntryService.getAllMilkEntries();
    }
    
    @PutMapping("/{id}")
    public MilkEntry updateMilkEntry(
            @PathVariable Long id,
            @RequestBody MilkEntry milkEntry) {

        return milkEntryService.updateMilkEntry(id, milkEntry);
    }

    @DeleteMapping("/{id}")
    public String deleteMilkEntry(@PathVariable Long id) {

        return milkEntryService.deleteMilkEntry(id);
    }
}
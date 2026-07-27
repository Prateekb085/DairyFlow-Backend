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
}
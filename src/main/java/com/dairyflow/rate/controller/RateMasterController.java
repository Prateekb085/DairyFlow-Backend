package com.dairyflow.rate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dairyflow.rate.entity.RateMaster;
import com.dairyflow.rate.service.RateMasterService;

@RestController
@RequestMapping("/api/rates")
public class RateMasterController {

    @Autowired
    private RateMasterService rateMasterService;

    @PostMapping
    public RateMaster addRate(@RequestBody RateMaster rateMaster) {
        return rateMasterService.addRate(rateMaster);
    }

    @GetMapping
    public List<RateMaster> getAllRates() {
        return rateMasterService.getAllRates();
    }

    @GetMapping("/search")
    public RateMaster getRate(@RequestParam String milkType,
                              @RequestParam Double fat) {
        return rateMasterService.getRate(milkType, fat);
    }
}
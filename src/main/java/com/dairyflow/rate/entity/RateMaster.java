package com.dairyflow.rate.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "rate_master")
public class RateMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String milkType;

    private Double fat;

    private Double ratePerLiter;

    private LocalDate effectiveDate;

    public RateMaster() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getRatePerLiter() {
        return ratePerLiter;
    }

    public void setRatePerLiter(Double ratePerLiter) {
        this.ratePerLiter = ratePerLiter;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
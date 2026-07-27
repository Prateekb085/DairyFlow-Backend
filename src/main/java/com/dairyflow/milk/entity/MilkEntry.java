package com.dairyflow.milk.entity;

import java.time.LocalDate;

import com.dairyflow.farmer.entity.Farmer;

import jakarta.persistence.*;

@Entity
@Table(name = "milk_entries")
public class MilkEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    private LocalDate collectionDate;

    private String shift;

    private String milkType;

    private Double quantity;

    private Double fat;

    private Double ratePerLiter;

    private Double totalAmount;

    public MilkEntry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
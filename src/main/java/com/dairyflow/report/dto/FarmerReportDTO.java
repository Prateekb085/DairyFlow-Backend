package com.dairyflow.report.dto;

import java.time.LocalDate;

public class FarmerReportDTO {

    private LocalDate collectionDate;
    private String shift;
    private String milkType;
    private Double quantity;
    private Double fat;
    private Double ratePerLiter;
    private Double totalAmount;

    public FarmerReportDTO() {
    }

    public FarmerReportDTO(LocalDate collectionDate, String shift,
                           String milkType, Double quantity,
                           Double fat, Double ratePerLiter,
                           Double totalAmount) {
        this.collectionDate = collectionDate;
        this.shift = shift;
        this.milkType = milkType;
        this.quantity = quantity;
        this.fat = fat;
        this.ratePerLiter = ratePerLiter;
        this.totalAmount = totalAmount;
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
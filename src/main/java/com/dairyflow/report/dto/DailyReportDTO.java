package com.dairyflow.report.dto;

public class DailyReportDTO {

    private String farmerName;
    private String milkType;
    private Double quantity;
    private Double fatPercentage;
    private Double ratePerLiter;
    private Double totalAmount;

    public DailyReportDTO() {
    }

    public DailyReportDTO(String farmerName, String milkType,
                          Double quantity, Double fatPercentage,
                          Double ratePerLiter, Double totalAmount) {
        this.farmerName = farmerName;
        this.milkType = milkType;
        this.quantity = quantity;
        this.fatPercentage = fatPercentage;
        this.ratePerLiter = ratePerLiter;
        this.totalAmount = totalAmount;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
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

    public Double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(Double fatPercentage) {
        this.fatPercentage = fatPercentage;
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
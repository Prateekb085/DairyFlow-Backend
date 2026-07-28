package com.dairyflow.report.dto;

public class MonthlyReportDTO {

    private String farmerName;
    private String milkType;
    private Double totalQuantity;
    private Double totalAmount;

    public MonthlyReportDTO() {
    }

    public MonthlyReportDTO(String farmerName, String milkType,
                            Double totalQuantity, Double totalAmount) {
        this.farmerName = farmerName;
        this.milkType = milkType;
        this.totalQuantity = totalQuantity;
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

    public Double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
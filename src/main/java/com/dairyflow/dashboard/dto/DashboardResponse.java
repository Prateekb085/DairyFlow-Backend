package com.dairyflow.dashboard.dto;

public class DashboardResponse {

    private long totalFarmers;
    private double todayMilkCollection;
    private double todayRevenue;
    private long pendingPayments;
    private long totalPayments;

    public DashboardResponse() {
    }

    public long getTotalFarmers() {
        return totalFarmers;
    }

    public void setTotalFarmers(long totalFarmers) {
        this.totalFarmers = totalFarmers;
    }

    public double getTodayMilkCollection() {
        return todayMilkCollection;
    }

    public void setTodayMilkCollection(double todayMilkCollection) {
        this.todayMilkCollection = todayMilkCollection;
    }

    public double getTodayRevenue() {
        return todayRevenue;
    }

    public void setTodayRevenue(double todayRevenue) {
        this.todayRevenue = todayRevenue;
    }

    public long getPendingPayments() {
        return pendingPayments;
    }

    public void setPendingPayments(long pendingPayments) {
        this.pendingPayments = pendingPayments;
    }

    public long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }
}
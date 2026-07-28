package com.dairyflow.report.dto;

import java.time.LocalDate;

public class PaymentHistoryDTO {

    private LocalDate fromDate;
    private LocalDate toDate;
    private Double totalAmount;
    private String paymentStatus;

    public PaymentHistoryDTO() {
    }

    public PaymentHistoryDTO(LocalDate fromDate, LocalDate toDate,
                             Double totalAmount, String paymentStatus) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
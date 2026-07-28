package com.dairyflow.report.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dairyflow.report.dto.DailyReportDTO;
import com.dairyflow.report.dto.MonthlyReportDTO;
import com.dairyflow.report.service.ReportService;
import org.springframework.web.bind.annotation.PathVariable;
import com.dairyflow.report.dto.FarmerReportDTO;
import com.dairyflow.report.dto.PaymentHistoryDTO;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/api/reports/daily")
    public List<DailyReportDTO> getDailyReport(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return reportService.getDailyReport(date);
    }

    @GetMapping("/api/reports/monthly")
    public List<MonthlyReportDTO> getMonthlyReport(
            @RequestParam int month,
            @RequestParam int year) {

        return reportService.getMonthlyReport(month, year);
    }
    
    @GetMapping("/api/reports/farmer/{farmerId}")
    public List<FarmerReportDTO> getFarmerReport(
            @PathVariable Long farmerId) {

        return reportService.getFarmerReport(farmerId);
    }
    
    @GetMapping("/api/payments/history/{farmerId}")
    public List<PaymentHistoryDTO> getPaymentHistory(
            @PathVariable Long farmerId) {

        return reportService.getPaymentHistory(farmerId);
    }
}
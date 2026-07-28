package com.dairyflow.report.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.milk.repository.MilkEntryRepository;
import com.dairyflow.report.dto.DailyReportDTO;
import com.dairyflow.report.dto.MonthlyReportDTO;
import com.dairyflow.report.dto.FarmerReportDTO;
import com.dairyflow.payment.repository.PaymentRepository;
import com.dairyflow.report.dto.PaymentHistoryDTO;

@Service
public class ReportService {

    @Autowired
    private MilkEntryRepository milkEntryRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    
    public List<DailyReportDTO> getDailyReport(LocalDate date) {
        return milkEntryRepository.getDailyReport(date);
    }

    public List<MonthlyReportDTO> getMonthlyReport(int month, int year) {
        return milkEntryRepository.getMonthlyReport(month, year);
    }
    public List<FarmerReportDTO> getFarmerReport(Long farmerId) {
        return milkEntryRepository.getFarmerReport(farmerId);
    }
    
    public List<PaymentHistoryDTO> getPaymentHistory(Long farmerId) {
        return paymentRepository.getPaymentHistory(farmerId);
    }
}
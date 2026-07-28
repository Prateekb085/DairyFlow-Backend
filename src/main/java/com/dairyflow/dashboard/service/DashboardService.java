package com.dairyflow.dashboard.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.dashboard.dto.DashboardResponse;
import com.dairyflow.farmer.repository.FarmerRepository;
import com.dairyflow.milk.repository.MilkEntryRepository;
import com.dairyflow.payment.repository.PaymentRepository;

@Service
public class DashboardService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private MilkEntryRepository milkEntryRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public DashboardResponse getDashboardData() {

        DashboardResponse response = new DashboardResponse();

        response.setTotalFarmers(farmerRepository.count());
        response.setTodayMilkCollection(
                milkEntryRepository.getTodayMilkCollection(LocalDate.now()));
        response.setTodayRevenue(
                milkEntryRepository.getTodayRevenue(LocalDate.now()));
        response.setPendingPayments(
                paymentRepository.countByPaymentStatus("Pending"));
        response.setTotalPayments(
                paymentRepository.count());

        return response;
    }
}
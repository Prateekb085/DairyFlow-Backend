package com.dairyflow.payment.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dairyflow.farmer.entity.Farmer;
import com.dairyflow.farmer.repository.FarmerRepository;
import com.dairyflow.milk.repository.MilkEntryRepository;
import com.dairyflow.payment.entity.Payment;
import com.dairyflow.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private MilkEntryRepository milkEntryRepository;

    // Generate Payment
    public Payment generatePayment(
            Long farmerId,
            LocalDate fromDate,
            LocalDate toDate) {

        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        Double total = milkEntryRepository.calculateTotalAmount(
                farmerId,
                fromDate,
                toDate);

        Payment payment = new Payment();

        payment.setFarmer(farmer);
        payment.setFromDate(fromDate);
        payment.setToDate(toDate);
        payment.setTotalAmount(total);
        payment.setPaymentStatus("Pending");

        return paymentRepository.save(payment);
    }

    // Get All Payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get Payments By Farmer
    public List<Payment> getPaymentsByFarmer(Long farmerId) {
        return paymentRepository.findByFarmerId(farmerId);
    }

    // Update Payment Status
    public Payment updatePaymentStatus(Long paymentId, String status) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaymentStatus(status);

        return paymentRepository.save(payment);
    }
}
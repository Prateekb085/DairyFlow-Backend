package com.dairyflow.payment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dairyflow.payment.entity.Payment;
import com.dairyflow.payment.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Generate Payment
    @PostMapping("/generate")
    public Payment generatePayment(
            @RequestParam Long farmerId,
            @RequestParam LocalDate fromDate,
            @RequestParam LocalDate toDate) {

        return paymentService.generatePayment(
                farmerId,
                fromDate,
                toDate);
    }

    // Get All Payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get Payments By Farmer
    @GetMapping("/farmer/{id}")
    public List<Payment> getPaymentsByFarmer(
            @PathVariable Long id) {

        return paymentService.getPaymentsByFarmer(id);
    }

    // Update Payment Status
    @PutMapping("/{id}/status")
    public Payment updatePaymentStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return paymentService.updatePaymentStatus(id, status);
    }
}
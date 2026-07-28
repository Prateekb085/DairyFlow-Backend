package com.dairyflow.payment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dairyflow.payment.entity.Payment;
import com.dairyflow.report.dto.PaymentHistoryDTO;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByFarmerId(Long farmerId);

    long countByPaymentStatus(String paymentStatus);

    @Query("""
    SELECT new com.dairyflow.report.dto.PaymentHistoryDTO(
        p.fromDate,
        p.toDate,
        p.totalAmount,
        p.paymentStatus
    )
    FROM Payment p
    WHERE p.farmer.id = :farmerId
    ORDER BY p.fromDate DESC
    """)
    List<PaymentHistoryDTO> getPaymentHistory(
            @Param("farmerId") Long farmerId);
}
package com.dairyflow.milk.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dairyflow.milk.entity.MilkEntry;
import java.util.List;
import com.dairyflow.report.dto.DailyReportDTO;
import com.dairyflow.report.dto.MonthlyReportDTO;
import com.dairyflow.report.dto.FarmerReportDTO;

public interface MilkEntryRepository extends JpaRepository<MilkEntry, Long> {

    Optional<MilkEntry> findByFarmerIdAndCollectionDateAndShift(
            Long farmerId,
            LocalDate collectionDate,
            String shift);

    @Query("""
        SELECT COALESCE(SUM(m.totalAmount), 0)
        FROM MilkEntry m
        WHERE m.farmer.id = :farmerId
        AND m.collectionDate BETWEEN :fromDate AND :toDate
        """)
    Double calculateTotalAmount(
            @Param("farmerId") Long farmerId,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate);
    
    @Query("""
    		SELECT COALESCE(SUM(m.quantity),0)
    		FROM MilkEntry m
    		WHERE m.collectionDate = :date
    		""")
    		Double getTodayMilkCollection(@Param("date") LocalDate date);

    		@Query("""
    		SELECT COALESCE(SUM(m.totalAmount),0)
    		FROM MilkEntry m
    		WHERE m.collectionDate = :date
    		""")
    		Double getTodayRevenue(@Param("date") LocalDate date);
    		
    		@Query("""
    				SELECT new com.dairyflow.report.dto.DailyReportDTO(
    				    m.farmer.farmerName,
    				    m.milkType,
    				    m.quantity,
    				    m.fat,
    				    m.ratePerLiter,
    				    m.totalAmount
    				)
    				FROM MilkEntry m
    				WHERE m.collectionDate = :date
    				""")
    				List<DailyReportDTO> getDailyReport(@Param("date") LocalDate date);
    		
    		@Query("""
    				SELECT new com.dairyflow.report.dto.MonthlyReportDTO(
    				    m.farmer.farmerName,
    				    m.milkType,
    				    SUM(m.quantity),
    				    SUM(m.totalAmount)
    				)
    				FROM MilkEntry m
    				WHERE MONTH(m.collectionDate) = :month
    				AND YEAR(m.collectionDate) = :year
    				GROUP BY m.farmer.farmerName, m.milkType
    				""")
    				List<MonthlyReportDTO> getMonthlyReport(
    				        @Param("month") int month,
    				        @Param("year") int year);
    		
    		@Query("""
    				SELECT new com.dairyflow.report.dto.FarmerReportDTO(
    				    m.collectionDate,
    				    m.shift,
    				    m.milkType,
    				    m.quantity,
    				    m.fat,
    				    m.ratePerLiter,
    				    m.totalAmount
    				)
    				FROM MilkEntry m
    				WHERE m.farmer.id = :farmerId
    				ORDER BY m.collectionDate DESC
    				""")
    				List<FarmerReportDTO> getFarmerReport(@Param("farmerId") Long farmerId);
}


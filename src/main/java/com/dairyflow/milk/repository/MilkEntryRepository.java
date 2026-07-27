package com.dairyflow.milk.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dairyflow.milk.entity.MilkEntry;

@Repository
public interface MilkEntryRepository extends JpaRepository<MilkEntry, Long> {

    List<MilkEntry> findByCollectionDate(LocalDate collectionDate);

}
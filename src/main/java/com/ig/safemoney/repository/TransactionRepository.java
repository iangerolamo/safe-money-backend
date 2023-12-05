package com.ig.safemoney.repository;

import com.ig.safemoney.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Transactional
    List<Transaction> findByData(Date data);

    @Transactional
    @Query("SELECT t FROM Transaction t WHERE MONTH(t.data) = :month")
    List<Transaction> findByMonth(@Param("month") int month);

    @Transactional
    @Query("SELECT t FROM Transaction t WHERE YEAR(t.data) = :year")
    List<Transaction> findByYear(@Param("year") int year);

    @Transactional
    @Query("SELECT t FROM Transaction t WHERE t.data BETWEEN :startDate AND :endDate")
    List<Transaction> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}

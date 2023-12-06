package com.ig.safemoney.service;

import com.ig.safemoney.model.Transaction;
import com.ig.safemoney.model.dto.BalanceDTO;
import com.ig.safemoney.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BalanceService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<BalanceDTO> getAllBalance() {
        List<Transaction> transactions = transactionRepository.findAll();
        return this.getBalance(transactions);
    }

    public List<BalanceDTO> getBalanceByDate(Date date) {
        List<Transaction> transactions = transactionRepository.findByData(date);
        return this.getBalance(transactions);
    }

    public List<BalanceDTO> getBalanceByMonth(int month) {
        List<Transaction> transactions = transactionRepository.findByMonth(month);
        return this.getBalance(transactions);
    }

    public List<BalanceDTO> getBalanceByYear(int year) {
        List<Transaction> transactions = transactionRepository.findByYear(year);
        return this.getBalance(transactions);
    }

    public List<BalanceDTO> getBalanceByDateRange(
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate
    ) {
        List<Transaction> transactions = transactionRepository.findByDateRange(startDate, endDate);
        return this.getBalance(transactions);
    }

    public List<BalanceDTO> getBalance(List<Transaction> transactions) {
        BalanceDTO revenueBalance = new BalanceDTO();
        BalanceDTO billsBalance = new BalanceDTO();
        BalanceDTO foodBalance = new BalanceDTO();
        BalanceDTO shoppingBalance = new BalanceDTO();
        BalanceDTO otherBalance = new BalanceDTO();
        List<BalanceDTO> balance = new ArrayList<>();

        BigDecimal totalRevenue = new BigDecimal(0);
        BigDecimal totalShopping = new BigDecimal(0);
        BigDecimal totalFood = new BigDecimal(0);
        BigDecimal totalOthers = new BigDecimal(0);
        BigDecimal totalBills = new BigDecimal(0);

        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equals("Revenue")) {
                totalRevenue = transaction.getAmount().add(totalRevenue);
            }
            if (transaction.getCategory().equals("Shopping")) {
                totalShopping = transaction.getAmount().add(totalShopping);
            }
            if (transaction.getCategory().equals("Food & Drinks")) {
                totalFood = transaction.getAmount().add(totalFood);
            }
            if (transaction.getCategory().equals("Bills & Utilities")) {
                totalBills = transaction.getAmount().add(totalBills);
            }
            if (transaction.getCategory().equals("Others")) {
                totalOthers = transaction.getAmount().add(totalOthers);
            }
        }
        revenueBalance.setAmount(totalRevenue);
        shoppingBalance.setAmount(totalShopping);
        foodBalance.setAmount(totalFood);
        billsBalance.setAmount(totalBills);
        otherBalance.setAmount(totalOthers);

        revenueBalance.setCategory("Revenue");
        balance.add(revenueBalance);


        shoppingBalance.setCategory("Shopping");
        balance.add(shoppingBalance);


        foodBalance.setCategory("Food & Drinks");
        balance.add(foodBalance);


        billsBalance.setCategory("Bills & Utilities");
        balance.add(billsBalance);


        otherBalance.setCategory("Others");
        balance.add(otherBalance);


        return balance;
    }

}

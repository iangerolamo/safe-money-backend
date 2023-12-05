package com.ig.safemoney.service;

import com.ig.safemoney.model.Transaction;
import com.ig.safemoney.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        return optionalTransaction.map(transaction -> {
            BeanUtils.copyProperties(updatedTransaction, transaction, "id");
            return transactionRepository.save(transaction);
        }).orElse(null);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> getTransactionByData(Date inputData) {
        return transactionRepository.findByData(inputData);
    }

    public List<Transaction> getTransactionByDataRange(Date startDate, Date endDate) {
        return transactionRepository.findByDateRange(startDate, endDate);
    }

    public List<Transaction> getTransactionByMonth(int month) {
        return  transactionRepository.findByMonth(month);
    }

    public List<Transaction> getTransactionByYear(int year) {
        return  transactionRepository.findByYear(year);
    }

}

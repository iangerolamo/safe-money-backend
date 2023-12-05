package com.ig.safemoney.controller;

import com.ig.safemoney.model.Transaction;
import com.ig.safemoney.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

  private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

  private static final String NEW_TRANSACTION_LOG = "New transaction was created id:{}";
  private static final String TRANSACTION_UPDATED_LOG = "Transaction:{} was updated";

  @Autowired private TransactionService transactionService;

  @GetMapping()
  public ResponseEntity<List<Transaction>> getAllTransactions() {
    return ResponseEntity.ok(transactionService.getAllTransaction());
  }

  @PostMapping()
  public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
    final Transaction transactionCreated = transactionService.createTransaction(transaction);
    logger.info(NEW_TRANSACTION_LOG, transactionCreated.toString());
    return ResponseEntity.status(HttpStatus.CREATED).body(transactionCreated);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Transaction> updateTransaction(
      @PathVariable Long id, @RequestBody Transaction updatedTransaction) {
    Transaction updatedTransactionResult =
        transactionService.updateTransaction(id, updatedTransaction);

    if (updatedTransaction != null) {
        logger.info(TRANSACTION_UPDATED_LOG, updatedTransactionResult.toString());
        return ResponseEntity.ok(updatedTransactionResult);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public void deleteTransaction(@PathVariable Long id) {
    transactionService.deleteTransaction(id);
  }

  @GetMapping("/findByData")
  public ResponseEntity<List<Transaction>> getTransactionByDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
    return ResponseEntity.ok(transactionService.getTransactionByData(data));
  }

  @GetMapping("/findByMonth")
  public ResponseEntity<List<Transaction>> getTransactionByMonth(@RequestParam int month) {
    return ResponseEntity.ok(transactionService.getTransactionByMonth(month));
  }

  @GetMapping("/findByYear")
  public ResponseEntity<List<Transaction>> getTransactionByYear(@RequestParam int year) {
    return ResponseEntity.ok(transactionService.getTransactionByYear(year));
  }

  @GetMapping("/findByDataRange")
  public ResponseEntity<List<Transaction>> getTransactionByDateRange(
          @RequestParam
          @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
          @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate
  ) {
    return ResponseEntity.ok(transactionService.getTransactionByDataRange(startDate, endDate));
  }
}

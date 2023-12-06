package com.ig.safemoney.controller;

import com.ig.safemoney.model.dto.BalanceDTO;
import com.ig.safemoney.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Especifique o domínio permitido
@RequestMapping("/balance")
public class BalanceController {

    private static final Logger logger = LoggerFactory.getLogger(BalanceController.class);

    @Autowired
    private BalanceService balanceService;


    @GetMapping()
    public ResponseEntity<List<BalanceDTO>> getAllBalances() {

        return ResponseEntity.ok(balanceService.getAllBalance());
    }

    @GetMapping("/byMonth")
    public ResponseEntity<List<BalanceDTO>> getBalanceByMonth(@RequestParam int month) {

        return ResponseEntity.ok(balanceService.getBalanceByMonth(month));
    }

    @GetMapping("/byYear")
    public ResponseEntity<List<BalanceDTO>> getBalanceByYear(@RequestParam int year) {

        return ResponseEntity.ok(balanceService.getBalanceByYear(year));
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<BalanceDTO>> getBalanceByDate(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date data
    ) {
        return ResponseEntity.ok(balanceService.getBalanceByDate(data));
    }

    @GetMapping("/byDateRange")
    public ResponseEntity<List<BalanceDTO>> getBalanceByDateRange(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate
    ) {
        return ResponseEntity.ok(balanceService.getBalanceByDateRange(startDate, endDate));
    }



}

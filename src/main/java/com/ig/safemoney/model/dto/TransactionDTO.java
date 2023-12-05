package com.ig.safemoney.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionDTO {

    private String title;
    private String category;
    private BigDecimal amount;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    public TransactionDTO() {
    }

    public TransactionDTO(String title,
                          String category,
                          BigDecimal amount,
                          Date date) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}

package com.ig.safemoney.model.dto;

import java.math.BigDecimal;

public class TransactionDTO {

    private String title;
    private String category;
    private BigDecimal amount;
    private String date;

    public TransactionDTO() {
    }

    public TransactionDTO(String title,
                          String category,
                          BigDecimal amount,
                          String date) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}

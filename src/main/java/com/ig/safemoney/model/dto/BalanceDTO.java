package com.ig.safemoney.model.dto;

import java.math.BigDecimal;

public class BalanceDTO {

    private String category;
    private BigDecimal amount;

    public BalanceDTO() {
    }

    public BalanceDTO(String category,
                      BigDecimal amount) {
        this.category = category;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "BalanceDTO{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}

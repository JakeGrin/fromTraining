package com.training.sgorodecki.homework4.homework4_1;

import java.math.BigDecimal;

public abstract class Card {
    private String cardHolderName;
    private BigDecimal accountBalance;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}


package com.training.sgorodecki.homework3.homework3_1;

import java.math.BigDecimal;

public class Card {
    private String cardHolderName;
    private BigDecimal accountBalance;


    public Card(String cardHolderName, BigDecimal accountBalance) {
        this.cardHolderName = cardHolderName;
        this.accountBalance = accountBalance;
    }

    public Card(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

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
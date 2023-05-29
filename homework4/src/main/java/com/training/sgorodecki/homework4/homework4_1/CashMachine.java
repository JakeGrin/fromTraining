package com.training.sgorodecki.homework4.homework4_1;

import java.math.BigDecimal;

public class CashMachine {
    private static final String AMOUNT_IS_NEGATIVE = "amount is negative";
    private static final String NOT_ENOUGH_MONEY = "Not enough money";

    public BigDecimal addToCard(Card card, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            BigDecimal accountBalance = card.getAccountBalance();
            BigDecimal newAccountBalance = accountBalance.add(amount);
            card.setAccountBalance(newAccountBalance);
            return newAccountBalance;
        } else {
            throw new UnsupportedOperationException(AMOUNT_IS_NEGATIVE);
        }
    }

    public BigDecimal withdrawFromCard(Card card, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            BigDecimal accountBalance = card.getAccountBalance();
            BigDecimal newAccountBalance = accountBalance.subtract(amount);
            if (newAccountBalance.compareTo(BigDecimal.ZERO) < 0) {
                if (card instanceof DebitCard) {
                    throw new UnsupportedOperationException(NOT_ENOUGH_MONEY);
                } else {
                    card.setAccountBalance(newAccountBalance);
                }
            }
            return newAccountBalance;
        } else {
            throw new UnsupportedOperationException(AMOUNT_IS_NEGATIVE);
        }
    }
}
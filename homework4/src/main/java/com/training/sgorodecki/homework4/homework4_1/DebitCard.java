package com.training.sgorodecki.homework4.homework4_1;

import java.math.BigDecimal;

public class DebitCard extends Card {

    private BigDecimal accountBalance;

    @Override
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    @Override
    public void setAccountBalance(BigDecimal accountBalance) {
        if (accountBalance.compareTo(new BigDecimal(0)) >= 0) {
            this.accountBalance = accountBalance;
        } else {
            throw new UnsupportedOperationException("Balance shouldn't be negative");
        }
    }
}

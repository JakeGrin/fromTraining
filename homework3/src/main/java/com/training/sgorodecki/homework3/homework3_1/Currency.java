package com.training.sgorodecki.homework3.homework3_1;

import java.math.BigDecimal;

public class Currency {
    private BigDecimal exchangeRate;

    public Currency(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}

package com.training.sgorodecki.homework.homework10;

import java.math.BigDecimal;

public class MoneyConsumer {
    private Card card;

    public MoneyConsumer(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean withdraw(BigDecimal amountForWithdraw) {
        return card.withdraw(amountForWithdraw);
    }
}
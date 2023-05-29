package com.training.sgorodecki.homework.homework10;

import java.math.BigDecimal;

public class MoneyProducer {
    private Card card;

    public MoneyProducer(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean add(BigDecimal amountForAdding) {
        return card.add(amountForAdding);
    }
}


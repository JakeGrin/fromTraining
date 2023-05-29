package com.training.sgorodecki.homework.homework10.runnable;

import com.training.sgorodecki.homework.homework10.MoneyProducer;

import java.math.BigDecimal;
import java.util.Random;

public class AddingTask implements Runnable {
    private MoneyProducer moneyProducer;

    public AddingTask(MoneyProducer moneyProducer) {
        this.moneyProducer = moneyProducer;
    }

    public MoneyProducer getMoneyProducer() {
        return moneyProducer;
    }

    public void setMoneyProducer(MoneyProducer moneyProducer) {
        this.moneyProducer = moneyProducer;
    }

    @Override
    public void run() {
        boolean isPossibleToContinueWork = true;
        while (isPossibleToContinueWork) {
            BigDecimal amountRandom = new BigDecimal(new Random().nextInt(25) + 25);
            isPossibleToContinueWork = moneyProducer.add(amountRandom);
        }
        if (!isPossibleToContinueWork) {
            System.out.println(Thread.currentThread().getName() + " is finished.");
        }
    }
}



package com.training.sgorodecki.homework.homework10.runnable;

import com.training.sgorodecki.homework.homework10.MoneyConsumer;

import java.math.BigDecimal;
import java.util.Random;

public class WithdrawingTask implements Runnable {
    private MoneyConsumer moneyConsumer;

    public WithdrawingTask(MoneyConsumer moneyConsumer) {
        this.moneyConsumer = moneyConsumer;
    }

    public MoneyConsumer getMoneyConsumer() {
        return moneyConsumer;
    }

    public void setMoneyConsumer(MoneyConsumer moneyConsumer) {
        this.moneyConsumer = moneyConsumer;
    }

    @Override
    public void run() {
        boolean isPossibleToContinueWork = true;
        while (isPossibleToContinueWork) {
            BigDecimal amountRandom = new BigDecimal(new Random().nextInt(25) + 25);
            isPossibleToContinueWork = moneyConsumer.withdraw(amountRandom);
        }
        if (!isPossibleToContinueWork) {
            System.out.println(Thread.currentThread().getName() + " is finished.");
        }
    }
}

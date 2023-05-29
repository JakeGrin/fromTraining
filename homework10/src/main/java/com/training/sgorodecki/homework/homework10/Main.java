package com.training.sgorodecki.homework.homework10;

import com.training.sgorodecki.homework.homework10.runnable.AddingTask;
import com.training.sgorodecki.homework.homework10.runnable.WithdrawingTask;

import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Card card = new Card(BigDecimal.valueOf(500));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(8);
        executorService.scheduleWithFixedDelay(new AddingTask(new MoneyProducer(card)), 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new AddingTask(new MoneyProducer(card)), 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new AddingTask(new MoneyProducer(card)), 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new AddingTask(new MoneyProducer(card)), 1000, 500, TimeUnit.MILLISECONDS);

        executorService.scheduleWithFixedDelay(new WithdrawingTask(new MoneyConsumer(card)), 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new WithdrawingTask(new MoneyConsumer(card)), 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new WithdrawingTask(new MoneyConsumer(card)), 1000, 500, TimeUnit.MILLISECONDS);
        executorService.scheduleWithFixedDelay(new WithdrawingTask(new MoneyConsumer(card)), 1000, 500, TimeUnit.MILLISECONDS);

        Thread.sleep(2000);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
    }
}
package com.training.sgorodecki.homework.homework10;

import java.math.BigDecimal;

public class Card {
    public BigDecimal balance;

    public Card(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean add(BigDecimal amountForAdding) {
        synchronized (this) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isBalanceLessThenThousand() && isBalanceMoreOrEqualMinimalAmount()) {
                balance = balance.add(amountForAdding);
                System.out.println(Thread.currentThread().getName() + " Balance was increased on " + amountForAdding +
                        ". Now your balance is " + balance);
                return true;
            }
        }
        return false;
    }

    private boolean isBalanceMoreOrEqualMinimalAmount() {
        return balance.compareTo(new BigDecimal(25)) >= 0;
    }

    private boolean isBalanceLessThenThousand() {
        return balance.compareTo(new BigDecimal(1000)) < 0;
    }

    public boolean withdraw(BigDecimal amountForWithdraw) {
        synchronized (this) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isBalanceLessThenThousand() && isBalanceMoreOrEqualMinimalAmount() &&
                    isBalanceMoreOrEqualAmountForWithdraw(amountForWithdraw)) {
                balance = balance.subtract(amountForWithdraw);
                System.out.println(Thread.currentThread().getName() + " Balance was decreased with " +
                        amountForWithdraw + ". Now your balance is " + balance);
                return true;
            }
        }
        return false;
    }

    private boolean isBalanceMoreOrEqualAmountForWithdraw(BigDecimal amountForWithdraw) {
        return balance.compareTo(amountForWithdraw) >= 0;
    }
}
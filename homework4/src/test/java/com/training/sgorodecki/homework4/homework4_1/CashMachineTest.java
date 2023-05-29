package com.training.sgorodecki.homework4.homework4_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CashMachineTest {

    private static final int ONE_HUNDRED = 100;
    private static final int ONE_HUNDRED_TEN = 110;
    private static final int NEGATIVE_ONE_HUNDRED_TEN = -110;
    private static final int TEN = 10;
    private static final int NINETY = 90;
    private static final int NEGATIVE_NINETY = -90;
    private static final int NEGATIVE_TEN = -10;
    private static final int NEGATIVE_ONE_HUNDRED = -100;

    private CashMachine cashMachine;
    private DebitCard debitCard;
    private CreditCard creditCard;

    @Before
    public void setUp() throws Exception {
        cashMachine = new CashMachine();
        debitCard = new DebitCard();
        debitCard.setAccountBalance(new BigDecimal(ONE_HUNDRED));
        creditCard = new CreditCard();
        creditCard.setAccountBalance(new BigDecimal(NEGATIVE_ONE_HUNDRED));
    }

    @Test
    public void testAddToDebitCard() {
        BigDecimal expected = new BigDecimal(ONE_HUNDRED_TEN);
        BigDecimal amount = new BigDecimal(TEN);
        BigDecimal actual = cashMachine.addToCard(debitCard, amount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddToCreditCard() {
        BigDecimal expected = new BigDecimal(NEGATIVE_NINETY);
        BigDecimal amount = new BigDecimal(TEN);
        BigDecimal actual = cashMachine.addToCard(creditCard, amount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawFromDebitCard() {
        BigDecimal expected = new BigDecimal(NINETY);
        BigDecimal amount = new BigDecimal(TEN);
        BigDecimal actual = cashMachine.withdrawFromCard(debitCard, amount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawFromCreditCard() {
        BigDecimal expected = new BigDecimal(NEGATIVE_ONE_HUNDRED_TEN);
        BigDecimal amount = new BigDecimal(TEN);
        BigDecimal actual = cashMachine.withdrawFromCard(creditCard, amount);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeAmountAddToCreditCard() {
        BigDecimal amount = new BigDecimal(NEGATIVE_TEN);
        cashMachine.addToCard(creditCard, amount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeAmountAddToDebitCard() {
        BigDecimal amount = new BigDecimal(NEGATIVE_TEN);
        cashMachine.addToCard(debitCard, amount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeAmountWithdrawFromCreditCard() {
        BigDecimal amount = new BigDecimal(NEGATIVE_TEN);
        cashMachine.withdrawFromCard(creditCard, amount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeAmountWithdrawFromDebitCard() {
        BigDecimal amount = new BigDecimal(NEGATIVE_TEN);
        cashMachine.withdrawFromCard(debitCard, amount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeBalanceWithdrawFromDebitCard() {
        BigDecimal amount = new BigDecimal(ONE_HUNDRED_TEN);
        cashMachine.withdrawFromCard(debitCard, amount);
    }
}
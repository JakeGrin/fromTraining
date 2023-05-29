package com.training.sgorodecki.homework3.homework3_1;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceProcessorTest {

    public static final int ONE_HUNDRED = 100;
    public static final int ONE_HUNDRED_TEN = 110;
    public static final int TEN = 10;
    public static final int NINETY = 90;
    public static final int NEGATIVE_TEN = -10;
    public static final int FIFTY = 50;
    public static final int TWO = 2;
    private BalanceProcessor balanceProcessor = new BalanceProcessor();
    private Card card = new Card("CARD HOLDER NAME", new BigDecimal(ONE_HUNDRED));

    @Test
    public void testGetFromCard() {
        BigDecimal expected = new BigDecimal(ONE_HUNDRED);
        BigDecimal actual = balanceProcessor.getCardBalance(card);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddToCard() {
        BigDecimal expected = new BigDecimal(ONE_HUNDRED_TEN);
        BigDecimal amount = new BigDecimal(TEN);
        BigDecimal actual = balanceProcessor.addToCard(card, amount);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWithdrawFromCard() {
        BigDecimal expected = new BigDecimal(NINETY);
        BigDecimal amount = new BigDecimal(TEN);
        BigDecimal actual = balanceProcessor.withdrawFromCard(card, amount);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeAmountAddToCard() {
        BigDecimal amount = new BigDecimal(NEGATIVE_TEN);
        balanceProcessor.addToCard(card, amount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeAmountWithdrawFromCard() {
        BigDecimal amount = new BigDecimal(NEGATIVE_TEN);
        balanceProcessor.withdrawFromCard(card, amount);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNegativeBalanceWithdrawFromCard() {
        BigDecimal amount = new BigDecimal(ONE_HUNDRED_TEN);
        balanceProcessor.withdrawFromCard(card, amount);
    }

    @Test
    public void testExchangeIntoMyCurrency() {
        BigDecimal expected = new BigDecimal(FIFTY);
        Currency currency = new Currency(new BigDecimal(TWO));
        BigDecimal actual = balanceProcessor.getBalanceInAnotherCurrency(card, currency);
        Assert.assertEquals(expected, actual);
    }
}
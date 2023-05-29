package com.training.sgorodecki.homework3.homework3_1;

import java.math.BigDecimal;

public class BalanceProcessor {

    public static final String AMOUNT_IS_NEGATIVE = "amount is negative";
    public static final String NOT_ENOUGH_MONEY = "Not enough money";

    /**
     * method description - get balance from card.
     *
     * @param - variable card
     * @result -   account balance from given card
     */
    public BigDecimal getCardBalance(Card card) {
        return card.getAccountBalance();
    }

    /**
     * method description - add amount to card.
     *
     * @param - variable card, variable amount
     * @result -   account balance from given card with amount
     * If amount is negative,a warning message will appear
     */
    public BigDecimal addToCard(Card card, BigDecimal amount) {
        if (isPositive(amount)) {
            BigDecimal accountBalance = card.getAccountBalance();
            BigDecimal newAccountBalance = accountBalance.add(amount);
            card.setAccountBalance(newAccountBalance);
            return newAccountBalance;
        } else {
            throw new UnsupportedOperationException(AMOUNT_IS_NEGATIVE);
        }
    }

    private boolean isPositive(BigDecimal amount) {
        return amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    /**
     * method description - withdraw amount from card.
     *
     * @param - variable card, variable amount
     * @result -   account balance from given card without amount
     * If amount is less than null or more than account balance, a warning message will appear
     */
    public BigDecimal withdrawFromCard(Card card, BigDecimal amount) {
        if (isPositive(amount)) {
            BigDecimal accountBalance = card.getAccountBalance();
            BigDecimal newAccountBalance = accountBalance.subtract(amount);
            if (isPositive(newAccountBalance)) {
                card.setAccountBalance(newAccountBalance);
                return newAccountBalance;
            } else {
                throw new UnsupportedOperationException(NOT_ENOUGH_MONEY);
            }
        } else {
            throw new UnsupportedOperationException(AMOUNT_IS_NEGATIVE);
        }
    }

    /**
     * method description - exchange account balance into another currency.
     *
     * @param - variable card; variable myCurrency
     * @result -   account balance in new currency
     */

    public BigDecimal getBalanceInAnotherCurrency(Card card, Currency currency) {
        BigDecimal accountBalance = card.getAccountBalance();
        BigDecimal accountBalanceInNewCurrency = accountBalance.divide(currency.getExchangeRate());
        return accountBalanceInNewCurrency;
    }
}

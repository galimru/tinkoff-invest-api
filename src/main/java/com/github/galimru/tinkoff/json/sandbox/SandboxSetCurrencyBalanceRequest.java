package com.github.galimru.tinkoff.json.sandbox;

import com.github.galimru.tinkoff.json.common.Currency;

import java.math.BigDecimal;

public class SandboxSetCurrencyBalanceRequest {

    private Currency currency;
    private BigDecimal balance;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

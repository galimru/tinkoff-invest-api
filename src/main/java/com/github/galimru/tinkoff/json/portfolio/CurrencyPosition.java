package com.github.galimru.tinkoff.json.portfolio;

import java.math.BigDecimal;
import java.util.Currency;

public class CurrencyPosition {

    private Currency currency;
    private BigDecimal balance;
    private BigDecimal blocked;

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

    public BigDecimal getBlocked() {
        return blocked;
    }

    public void setBlocked(BigDecimal blocked) {
        this.blocked = blocked;
    }
}

package com.github.galimru.tinkoff.json.sandbox;

import java.math.BigDecimal;

public class SandboxSetPositionBalanceRequest {

    private String figi;
    private BigDecimal balance;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

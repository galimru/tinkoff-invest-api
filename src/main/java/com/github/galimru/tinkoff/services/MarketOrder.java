package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.json.common.OperationType;

import java.util.Objects;

public class MarketOrder {

    private final String figi;
    private final OperationType type;
    private Integer quantity;

    public MarketOrder(String figi, OperationType type) {
        this.figi = figi;
        this.type = type;
    }

    public static MarketOrder buy(String figi) {
        return new MarketOrder(figi, OperationType.BUY);
    }

    public static MarketOrder sell(String figi) {
        return new MarketOrder(figi, OperationType.SELL);
    }

    public MarketOrder quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getFigi() {
        return figi;
    }

    public OperationType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    protected void validate() {
        Objects.requireNonNull(type, "type is null");
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(quantity, "quantity is null");
    }

}

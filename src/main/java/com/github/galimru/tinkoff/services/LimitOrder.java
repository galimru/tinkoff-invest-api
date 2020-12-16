package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.json.common.OperationType;

import java.math.BigDecimal;
import java.util.Objects;

public class LimitOrder {

    private final String figi;
    private final OperationType type;
    private Integer quantity;
    private BigDecimal price;

    public LimitOrder(String figi, OperationType type) {
        this.figi = figi;
        this.type = type;
    }

    public static LimitOrder buy(String figi) {
        return new LimitOrder(figi, OperationType.BUY);
    }

    public static LimitOrder sell(String figi) {
        return new LimitOrder(figi, OperationType.SELL);
    }

    public LimitOrder quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public LimitOrder price(BigDecimal price) {
        this.price = price;
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

    public BigDecimal getPrice() {
        return price;
    }

    protected void validate() {
        Objects.requireNonNull(type, "type is null");
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(quantity, "quantity is null");
        Objects.requireNonNull(price, "price is null");
    }
}

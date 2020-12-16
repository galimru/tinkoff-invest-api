package com.github.galimru.tinkoff.json.orders;

import com.github.galimru.tinkoff.json.common.OperationType;

import java.math.BigDecimal;

public class LimitOrderRequest {

    private Integer lots;
    private OperationType operation;
    private BigDecimal price;

    public Integer getLots() {
        return lots;
    }

    public void setLots(Integer lots) {
        this.lots = lots;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

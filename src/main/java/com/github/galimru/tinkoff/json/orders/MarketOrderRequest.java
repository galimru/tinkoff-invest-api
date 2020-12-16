package com.github.galimru.tinkoff.json.orders;

import com.github.galimru.tinkoff.json.common.OperationType;

public class MarketOrderRequest {

    private Integer lots;
    private OperationType operation;

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
}

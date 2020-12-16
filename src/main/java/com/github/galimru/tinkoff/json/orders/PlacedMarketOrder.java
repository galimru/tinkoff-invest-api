package com.github.galimru.tinkoff.json.orders;

import com.github.galimru.tinkoff.json.common.MoneyAmount;
import com.github.galimru.tinkoff.json.common.OperationType;

public class PlacedMarketOrder {

    private String orderId;
    private OperationType operation;
    private OrderStatus status;
    private String rejectReason;
    private String message;
    private Integer requestedLots;
    private Integer executedLots;
    private MoneyAmount commission;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRequestedLots() {
        return requestedLots;
    }

    public void setRequestedLots(Integer requestedLots) {
        this.requestedLots = requestedLots;
    }

    public Integer getExecutedLots() {
        return executedLots;
    }

    public void setExecutedLots(Integer executedLots) {
        this.executedLots = executedLots;
    }

    public MoneyAmount getCommission() {
        return commission;
    }

    public void setCommission(MoneyAmount commission) {
        this.commission = commission;
    }
}

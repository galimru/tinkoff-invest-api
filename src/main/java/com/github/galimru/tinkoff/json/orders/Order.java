package com.github.galimru.tinkoff.json.orders;

import java.math.BigDecimal;

public class Order {

    private String orderId;
    private String figi;
    private OrderStatus status;
    private Integer requestedLots;
    private Integer executedLots;
    private OrderType type;
    private BigDecimal price;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

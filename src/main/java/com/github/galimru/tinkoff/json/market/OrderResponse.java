package com.github.galimru.tinkoff.json.market;

import java.math.BigDecimal;

public class OrderResponse {

    private BigDecimal price;
    private Integer quantity;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

package com.github.galimru.tinkoff.json.streaming;

import java.util.List;

public class OrderbookEvent {

    private String figi;
    private Integer depth;
    private List<OrderbookRow> bids;
    private List<OrderbookRow> asks;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public List<OrderbookRow> getBids() {
        return bids;
    }

    public void setBids(List<OrderbookRow> bids) {
        this.bids = bids;
    }

    public List<OrderbookRow> getAsks() {
        return asks;
    }

    public void setAsks(List<OrderbookRow> asks) {
        this.asks = asks;
    }
}

package com.github.galimru.tinkoff.json.market;

import java.math.BigDecimal;
import java.util.List;

public class Orderbook {

    private String figi;
    private Integer depth;
    private List<OrderResponse> bids;
    private List<OrderResponse> asks;
    private TradeStatus tradeStatus;
    private BigDecimal minPriceIncrement;
    private BigDecimal faceValue;
    private BigDecimal lastPrice;
    private BigDecimal closePrice;
    private BigDecimal limitUp;
    private BigDecimal limitDown;

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

    public List<OrderResponse> getBids() {
        return bids;
    }

    public void setBids(List<OrderResponse> bids) {
        this.bids = bids;
    }

    public List<OrderResponse> getAsks() {
        return asks;
    }

    public void setAsks(List<OrderResponse> asks) {
        this.asks = asks;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public BigDecimal getMinPriceIncrement() {
        return minPriceIncrement;
    }

    public void setMinPriceIncrement(BigDecimal minPriceIncrement) {
        this.minPriceIncrement = minPriceIncrement;
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getLimitUp() {
        return limitUp;
    }

    public void setLimitUp(BigDecimal limitUp) {
        this.limitUp = limitUp;
    }

    public BigDecimal getLimitDown() {
        return limitDown;
    }

    public void setLimitDown(BigDecimal limitDown) {
        this.limitDown = limitDown;
    }
}

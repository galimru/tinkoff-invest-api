package com.github.galimru.tinkoff.json.streaming;

import com.github.galimru.tinkoff.json.market.TradeStatus;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class InstrumentInfoEvent {

    private String figi;
    @SerializedName("trade_status")
    private TradeStatus tradeStatus;
    @SerializedName("min_price_increment")
    private BigDecimal minPriceIncrement;
    private Integer lot;
    @SerializedName("accrued_interest")
    private BigDecimal accruedInterest;
    @SerializedName("limit_up")
    private BigDecimal limitUp;
    @SerializedName("limit_down")
    private BigDecimal limitDown;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
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

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public BigDecimal getAccruedInterest() {
        return accruedInterest;
    }

    public void setAccruedInterest(BigDecimal accruedInterest) {
        this.accruedInterest = accruedInterest;
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

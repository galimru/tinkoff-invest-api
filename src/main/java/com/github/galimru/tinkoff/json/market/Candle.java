package com.github.galimru.tinkoff.json.market;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.Date;

public class Candle {

    private String figi;
    private CandleResolution interval;
    @SerializedName("o")
    private BigDecimal open;
    @SerializedName("c")
    private BigDecimal close;
    @SerializedName("h")
    private BigDecimal high;
    @SerializedName("l")
    private BigDecimal low;
    @SerializedName("v")
    private Integer volume;
    private Date time;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public CandleResolution getInterval() {
        return interval;
    }

    public void setInterval(CandleResolution interval) {
        this.interval = interval;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

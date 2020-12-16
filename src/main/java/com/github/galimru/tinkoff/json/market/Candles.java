package com.github.galimru.tinkoff.json.market;

import java.util.List;

public class Candles {

    private String figi;
    private CandleResolution interval;
    private List<Candle> candles;

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

    public List<Candle> getCandles() {
        return candles;
    }

    public void setCandles(List<Candle> candles) {
        this.candles = candles;
    }
}

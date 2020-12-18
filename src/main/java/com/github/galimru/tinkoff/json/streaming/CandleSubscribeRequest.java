package com.github.galimru.tinkoff.json.streaming;

import com.github.galimru.tinkoff.json.market.CandleResolution;

public class CandleSubscribeRequest extends EventRequest {

    private String figi;
    private CandleResolution interval;

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
}

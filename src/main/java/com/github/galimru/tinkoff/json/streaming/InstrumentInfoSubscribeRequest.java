package com.github.galimru.tinkoff.json.streaming;

public class InstrumentInfoSubscribeRequest extends EventRequest {

    private String figi;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

}

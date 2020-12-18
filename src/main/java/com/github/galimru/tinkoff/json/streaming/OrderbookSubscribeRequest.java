package com.github.galimru.tinkoff.json.streaming;

public class OrderbookSubscribeRequest extends EventRequest {

    private String figi;
    private Integer depth;

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
}

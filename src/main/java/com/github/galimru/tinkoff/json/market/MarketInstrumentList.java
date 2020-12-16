package com.github.galimru.tinkoff.json.market;

import java.util.List;

public class MarketInstrumentList {

    private Integer total;
    private List<MarketInstrument> instruments;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<MarketInstrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<MarketInstrument> instruments) {
        this.instruments = instruments;
    }
}

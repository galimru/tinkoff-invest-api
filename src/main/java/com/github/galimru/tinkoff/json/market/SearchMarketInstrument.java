package com.github.galimru.tinkoff.json.market;

import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.common.InstrumentType;

import java.math.BigDecimal;

public class SearchMarketInstrument {

    private String figi;
    private String ticker;
    private String isin;
    private BigDecimal minPriceIncrement;
    private Integer lot;
    private Currency currency;
    private String name;
    private InstrumentType type;

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstrumentType getType() {
        return type;
    }

    public void setType(InstrumentType type) {
        this.type = type;
    }
}

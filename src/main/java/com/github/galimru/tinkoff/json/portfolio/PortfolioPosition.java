package com.github.galimru.tinkoff.json.portfolio;

import com.github.galimru.tinkoff.json.common.InstrumentType;
import com.github.galimru.tinkoff.json.common.MoneyAmount;

import java.math.BigDecimal;

public class PortfolioPosition {

    private String figi;
    private String ticker;
    private String isin;
    private InstrumentType instrumentType;
    private BigDecimal balance;
    private BigDecimal blocked;
    private MoneyAmount expectedYield;
    private Integer lots;
    private MoneyAmount averagePositionPrice;
    private MoneyAmount averagePositionPriceNoNkd;
    private String name;

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

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBlocked() {
        return blocked;
    }

    public void setBlocked(BigDecimal blocked) {
        this.blocked = blocked;
    }

    public MoneyAmount getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(MoneyAmount expectedYield) {
        this.expectedYield = expectedYield;
    }

    public Integer getLots() {
        return lots;
    }

    public void setLots(Integer lots) {
        this.lots = lots;
    }

    public MoneyAmount getAveragePositionPrice() {
        return averagePositionPrice;
    }

    public void setAveragePositionPrice(MoneyAmount averagePositionPrice) {
        this.averagePositionPrice = averagePositionPrice;
    }

    public MoneyAmount getAveragePositionPriceNoNkd() {
        return averagePositionPriceNoNkd;
    }

    public void setAveragePositionPriceNoNkd(MoneyAmount averagePositionPriceNoNkd) {
        this.averagePositionPriceNoNkd = averagePositionPriceNoNkd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.github.galimru.tinkoff.json.portfolio;

import java.util.List;

public class Currencies {

    private List<CurrencyPosition> currencies;

    public List<CurrencyPosition> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyPosition> currencies) {
        this.currencies = currencies;
    }
}

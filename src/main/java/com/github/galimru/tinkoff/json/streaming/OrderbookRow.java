package com.github.galimru.tinkoff.json.streaming;

import java.math.BigDecimal;
import java.util.ArrayList;

public class OrderbookRow extends ArrayList<Number> {

    private static final int PRICE_INDEX = 0;
    private static final int VOLUME_INDEX = 1;

    public BigDecimal getPrice() {
        return (BigDecimal) get(PRICE_INDEX);
    }

    public Integer getVolume() {
        return (Integer) get(VOLUME_INDEX);
    }
}

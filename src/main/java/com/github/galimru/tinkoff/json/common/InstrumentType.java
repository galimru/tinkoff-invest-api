package com.github.galimru.tinkoff.json.common;

import com.google.gson.annotations.SerializedName;

public enum InstrumentType {
    @SerializedName("Stock")
    STOCK,
    @SerializedName("Currency")
    CURRENCY,
    @SerializedName("Bond")
    BOND,
    @SerializedName("Etf")
    ETF
}

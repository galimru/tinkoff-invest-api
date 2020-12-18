package com.github.galimru.tinkoff.services.streaming;

import com.google.gson.annotations.SerializedName;

public enum Event {
    @SerializedName("candle")
    CANDLE,
    @SerializedName("orderbook")
    ORDERBOOK,
    @SerializedName("instrument_info")
    INSTRUMENT_INFO
}

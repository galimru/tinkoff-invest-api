package com.github.galimru.tinkoff.json.common;

import com.google.gson.annotations.SerializedName;

public enum OperationType {
    @SerializedName("Buy")
    BUY,
    @SerializedName("Sell")
    SELL
}

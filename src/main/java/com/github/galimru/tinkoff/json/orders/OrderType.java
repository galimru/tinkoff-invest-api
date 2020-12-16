package com.github.galimru.tinkoff.json.orders;

import com.google.gson.annotations.SerializedName;

public enum OrderType {
    @SerializedName("Limit")
    LIMIT,
    @SerializedName("Market")
    MARKET
}

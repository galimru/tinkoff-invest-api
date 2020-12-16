package com.github.galimru.tinkoff.json.market;

import com.google.gson.annotations.SerializedName;

public enum TradeStatus {
    @SerializedName("NormalTrading")
    NORMAL_TRADING,
    @SerializedName("NotAvailableForTrading")
    NOT_AVAILABLE_FOR_TRADING
}

package com.github.galimru.tinkoff.json.common;

import com.google.gson.annotations.SerializedName;

public enum BrokerAccountType {
    @SerializedName("Tinkoff")
    TINKOFF,
    @SerializedName("TinkoffIis")
    TINKOFF_IIS
}

package com.github.galimru.tinkoff.json.market;

import com.google.gson.annotations.SerializedName;

public enum CandleResolution {
    @SerializedName("1min")
    MIN_1,
    @SerializedName("2min")
    MIN_2,
    @SerializedName("3min")
    MIN_3,
    @SerializedName("5min")
    MIN_5,
    @SerializedName("10min")
    MIN_10,
    @SerializedName("15min")
    MIN_15,
    @SerializedName("30min")
    MIN_30,
    @SerializedName("hour")
    HOUR,
    @SerializedName("day")
    DAY,
    @SerializedName("week")
    WEEK,
    @SerializedName("month")
    MONTH;
}

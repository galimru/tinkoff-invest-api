package com.github.galimru.tinkoff.json.market;

import com.google.gson.annotations.SerializedName;

public enum CandleResolution {
    @SerializedName("1min")
    ONE_MINUTE,
    @SerializedName("2min")
    TWO_MINUTES,
    @SerializedName("3min")
    THREE_MINUTES,
    @SerializedName("5min")
    FIVE_MINUTES,
    @SerializedName("10min")
    TEN_MINUTES,
    @SerializedName("15min")
    FIFTEEN_MINUTES,
    @SerializedName("30min")
    THIRTY_MINUTES,
    @SerializedName("hour")
    HOUR,
    @SerializedName("day")
    DAY,
    @SerializedName("week")
    WEEK,
    @SerializedName("month")
    MONTH;
}

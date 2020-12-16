package com.github.galimru.tinkoff.json.orders;

import com.google.gson.annotations.SerializedName;

public enum OrderStatus {
    @SerializedName("New")
    NEW,
    @SerializedName("PartiallyFill")
    PARTIALLY_FILL,
    @SerializedName("Fill")
    FILL,
    @SerializedName("Cancelled")
    CANCELLED,
    @SerializedName("Replaced")
    REPLACED,
    @SerializedName("PendingCancel")
    PENDING_CANCEL,
    @SerializedName("Rejected")
    REJECTED,
    @SerializedName("PendingReplace")
    PENDING_REPLACE,
    @SerializedName("PendingNew")
    PENDING_NEW
}

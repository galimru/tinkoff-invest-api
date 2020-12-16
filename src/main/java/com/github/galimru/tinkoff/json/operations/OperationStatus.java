package com.github.galimru.tinkoff.json.operations;

import com.google.gson.annotations.SerializedName;

public enum OperationStatus {
    @SerializedName("Done")
    DONE,
    @SerializedName("Decline")
    DECLINE,
    @SerializedName("Progress")
    PROGRESS
}

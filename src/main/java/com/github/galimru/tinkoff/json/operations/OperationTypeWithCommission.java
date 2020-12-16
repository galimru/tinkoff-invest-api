package com.github.galimru.tinkoff.json.operations;

import com.google.gson.annotations.SerializedName;

public enum OperationTypeWithCommission {

    @SerializedName("Buy")
    BUY,
    @SerializedName("BuyCard")
    BUY_CARD,
    @SerializedName("Sell")
    SELL,
    @SerializedName("BrokerCommission")
    BROKER_COMMISSION,
    @SerializedName("ExchangeCommission")
    EXCHANGE_COMMISSION,
    @SerializedName("ServiceCommission")
    SERVICE_COMMISSION,
    @SerializedName("MarginCommission")
    MARGIN_COMMISSION,
    @SerializedName("OtherCommission")
    OTHER_COMMISSION,
    @SerializedName("PayIn")
    PAY_IN,
    @SerializedName("PayOut")
    PAY_OUT,
    @SerializedName("Tax")
    TAX,
    @SerializedName("TaxLucre")
    TAX_LUCRE,
    @SerializedName("TaxDividend")
    TAX_DIVIDEND,
    @SerializedName("TaxCoupon")
    TAX_COUPON,
    @SerializedName("TaxBack")
    TAX_BACK,
    @SerializedName("Repayment")
    REPAYMENT,
    @SerializedName("PartRepayment")
    PART_REPAYMENT,
    @SerializedName("Coupon")
    COUPON,
    @SerializedName("Dividend")
    DIVIDEND,
    @SerializedName("SecurityIn")
    SECURITY_IN,
    @SerializedName("SecurityOut")
    SECURITY_OUT
}

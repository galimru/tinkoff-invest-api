package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.market.CandleResolution;
import com.github.galimru.tinkoff.json.streaming.CandleSubscribeRequest;

import java.util.Objects;

public class CandleSubscription extends Subscription<CandleSubscribeRequest> {

    private final static String SUBSCRIBE_EVENT = "candle:subscribe";
    private final static String UNSUBSCRIBE_EVENT = "candle:unsubscribe";

    private final String figi;
    private CandleResolution interval;

    private CandleSubscription(String figi) {
        this.figi = figi;
    }

    public static CandleSubscription on(String figi) {
        return new CandleSubscription(figi);
    }

    public CandleSubscription withInterval(CandleResolution interval) {
        this.interval = interval;
        return this;
    }

    public String getFigi() {
        return figi;
    }

    public CandleResolution getInterval() {
        return interval;
    }

    @Override
    protected CandleSubscribeRequest buildSubscribeRequest() {
        return buildRequest(SUBSCRIBE_EVENT);
    }

    @Override
    protected CandleSubscribeRequest buildUnsubscribeRequest() {
        return buildRequest(UNSUBSCRIBE_EVENT);
    }

    private CandleSubscribeRequest buildRequest(String event) {
        Objects.requireNonNull(event, "event is null");
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(interval, "interval is null");

        CandleSubscribeRequest request = new CandleSubscribeRequest();
        request.setEvent(event);
        request.setFigi(figi);
        request.setInterval(interval);
        return request;
    }
}

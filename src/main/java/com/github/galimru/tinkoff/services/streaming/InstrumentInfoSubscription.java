package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.InstrumentInfoSubscribeRequest;

import java.util.Objects;

public class InstrumentInfoSubscription extends Subscription<InstrumentInfoSubscribeRequest> {

    private final static String SUBSCRIBE_EVENT = "instrument_info:subscribe";
    private final static String UNSUBSCRIBE_EVENT = "instrument_info:unsubscribe";

    private final String figi;

    private InstrumentInfoSubscription(String figi) {
        this.figi = figi;
    }

    public static InstrumentInfoSubscription on(String figi) {
        return new InstrumentInfoSubscription(figi);
    }

    public String getFigi() {
        return figi;
    }

    @Override
    protected InstrumentInfoSubscribeRequest buildSubscribeRequest() {
        return buildRequest(SUBSCRIBE_EVENT);
    }

    @Override
    protected InstrumentInfoSubscribeRequest buildUnsubscribeRequest() {
        return buildRequest(UNSUBSCRIBE_EVENT);
    }

    private InstrumentInfoSubscribeRequest buildRequest(String event) {
        Objects.requireNonNull(event, "event is null");
        Objects.requireNonNull(figi, "figi is null");

        InstrumentInfoSubscribeRequest request = new InstrumentInfoSubscribeRequest();
        request.setEvent(event);
        request.setFigi(figi);
        return request;
    }
}

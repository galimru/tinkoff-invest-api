package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.OrderbookSubscribeRequest;

import java.util.Objects;

public class OrderbookSubscription extends Subscription<OrderbookSubscribeRequest> {

    private final static String SUBSCRIBE_EVENT = "orderbook:subscribe";
    private final static String UNSUBSCRIBE_EVENT = "orderbook:unsubscribe";

    private final String figi;
    private Integer depth;

    private OrderbookSubscription(String figi) {
        this.figi = figi;
    }

    public static OrderbookSubscription on(String figi) {
        return new OrderbookSubscription(figi);
    }

    public OrderbookSubscription withDepth(Integer depth) {
        this.depth = depth;
        return this;
    }

    public String getFigi() {
        return figi;
    }

    public Integer getDepth() {
        return depth;
    }

    @Override
    protected OrderbookSubscribeRequest buildSubscribeRequest() {
        return buildRequest(SUBSCRIBE_EVENT);
    }

    @Override
    protected OrderbookSubscribeRequest buildUnsubscribeRequest() {
        return buildRequest(UNSUBSCRIBE_EVENT);
    }

    private OrderbookSubscribeRequest buildRequest(String event) {
        Objects.requireNonNull(event, "event is null");
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(depth, "depth is null");

        OrderbookSubscribeRequest request = new OrderbookSubscribeRequest();
        request.setEvent(event);
        request.setFigi(figi);
        request.setDepth(depth);
        return request;
    }
}

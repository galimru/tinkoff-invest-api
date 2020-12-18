package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.OrderbookEvent;

@FunctionalInterface
public interface OrderbookListener {
    void handle(OrderbookEvent event);
}

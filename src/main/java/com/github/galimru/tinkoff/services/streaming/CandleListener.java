package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.CandleEvent;

@FunctionalInterface
public interface CandleListener {
    void handle(CandleEvent event);
}

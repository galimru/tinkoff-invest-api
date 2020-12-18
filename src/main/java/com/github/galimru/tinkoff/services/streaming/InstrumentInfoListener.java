package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.InstrumentInfoEvent;

@FunctionalInterface
public interface InstrumentInfoListener {
    void handle(InstrumentInfoEvent event);
}

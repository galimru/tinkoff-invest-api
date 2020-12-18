package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.EventRequest;

public abstract class Subscription<T extends EventRequest> {
    protected abstract T buildSubscribeRequest();

    protected abstract T buildUnsubscribeRequest();
}

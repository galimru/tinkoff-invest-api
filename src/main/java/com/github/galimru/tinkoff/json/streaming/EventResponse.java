package com.github.galimru.tinkoff.json.streaming;

import com.github.galimru.tinkoff.services.streaming.Event;

import java.util.Date;

public class EventResponse<T> {

    private Event event;
    private Date time;
    private T payload;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}

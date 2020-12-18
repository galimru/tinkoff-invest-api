package com.github.galimru.tinkoff.services.streaming;

import com.github.galimru.tinkoff.json.streaming.*;
import com.github.galimru.tinkoff.utils.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class StreamingService {

    private final Logger logger = LoggerFactory.getLogger(StreamingService.class);

    private final Gson gson;
    private final WebSocket ws;

    private final Set<CandleListener> candleListeners = new HashSet<>();
    private final Set<OrderbookListener> orderbookListeners = new HashSet<>();
    private final Set<InstrumentInfoListener> instrumentInfoListeners = new HashSet<>();

    public StreamingService(OkHttpClient client, String url, String token) {
        gson = new Gson();
        Request handshakeRequest = new Request.Builder()
                .url(url)
                .addHeader(HttpUtil.AUTHORIZATION_HEADER, HttpUtil.BEARER_PREFIX + token)
                .build();
        ws = client.newWebSocket(handshakeRequest, new StreamingListener());
    }

    public StreamingService subscribe(Subscription<? extends EventRequest> subscription) {
        EventRequest request = subscription.buildSubscribeRequest();
        ws.send(gson.toJson(request));
        return this;
    }

    public StreamingService unsubscribe(Subscription<? extends EventRequest> subscription) {
        EventRequest request = subscription.buildUnsubscribeRequest();
        ws.send(gson.toJson(request));
        return this;
    }

    public StreamingService addCandleListener(CandleListener listener) {
        candleListeners.add(listener);
        return this;
    }

    public StreamingService removeCandleListener(CandleListener listener) {
        candleListeners.remove(listener);
        return this;
    }

    public StreamingService addOrderbookListener(OrderbookListener listener) {
        orderbookListeners.add(listener);
        return this;
    }

    public StreamingService removeOrderbookListener(OrderbookListener listener) {
        orderbookListeners.remove(listener);
        return this;
    }

    public StreamingService addInstrumentInfoListener(InstrumentInfoListener listener) {
        instrumentInfoListeners.add(listener);
        return this;
    }

    public StreamingService removeInstrumentInfoListener(InstrumentInfoListener listener) {
        instrumentInfoListeners.remove(listener);
        return this;
    }

    class StreamingListener extends WebSocketListener {

        @Override
        public void onFailure(@Nonnull WebSocket webSocket, Throwable t, @Nullable Response response) {
            logger.error("WebSocket failure", t);
        }

        @Override
        public void onClosing(@Nonnull WebSocket webSocket, int code, @Nonnull String reason) {
            ws.close(1000, reason);
        }

        @Override
        public void onMessage(@Nonnull WebSocket webSocket, @Nonnull String text) {
            Type eventType = new TypeToken<EventResponse<Object>>() {}.getType();
            EventResponse<?> eventResponse = gson.fromJson(text, eventType);
            fireEvent(eventResponse, text);
        }

        private void fireEvent(EventResponse<?> eventResponse, String body) {
            switch (eventResponse.getEvent()) {
                case CANDLE:
                    CandleSubscribeResponse candleResponse = gson
                            .fromJson(body, CandleSubscribeResponse.class);
                    fireCandleEvent(candleResponse.getPayload());
                    break;
                case ORDERBOOK:
                    OrderbookSubscribeResponse orderbookResponse = gson
                            .fromJson(body, OrderbookSubscribeResponse.class);
                    fireOrderbookEvent(orderbookResponse.getPayload());
                    break;
                case INSTRUMENT_INFO:
                    InstrumentInfoSubscribeResponse instrumentInfoResponse = gson
                            .fromJson(body, InstrumentInfoSubscribeResponse.class);
                    fireInstrumentInfoEvent(instrumentInfoResponse.getPayload());
                    break;
            }
        }

        private void fireCandleEvent(CandleEvent event) {
            candleListeners.forEach(listener -> listener.handle(event));
        }

        private void fireOrderbookEvent(OrderbookEvent event) {
            orderbookListeners.forEach(listener -> listener.handle(event));
        }

        private void fireInstrumentInfoEvent(InstrumentInfoEvent event) {
            instrumentInfoListeners.forEach(listener -> listener.handle(event));
        }
    }
}

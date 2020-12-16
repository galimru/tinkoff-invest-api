package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.MarketApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.market.*;
import com.github.galimru.tinkoff.utils.HttpUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class MarketService {

    private static final Integer DEFAULT_ORDERBOOK_DEPTH = 20;

    private final MarketApi api;

    public MarketService(Retrofit retrofit) {
        this.api = retrofit.create(MarketApi.class);
    }

    public MarketInstrumentList stocks() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.stocks().execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public MarketInstrumentList bonds() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.bonds().execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public MarketInstrumentList etfs() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.etfs().execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public MarketInstrumentList currencies() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.currencies().execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public Orderbook orderbook(String figi) throws IOException, ApiException {
        return orderbook(figi, DEFAULT_ORDERBOOK_DEPTH);
    }

    public Orderbook orderbook(String figi, Integer depth) throws IOException, ApiException {
        Response<OrderbookResponse> response = api.orderbook(figi, depth).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public Candles candles(String figi, Date from, Date to, CandleResolution interval) throws IOException, ApiException {
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(from, "from is null");
        Objects.requireNonNull(to, "to is null");
        Objects.requireNonNull(interval, "interval is null");

        Response<CandlesResponse> response = api.candles(figi, from, to, interval)
                .execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public SearchMarketInstrument searchByFigi(String figi) throws IOException, ApiException {
        Response<SearchMarketInstrumentResponse> response = api.searchByFigi(figi).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public MarketInstrumentList searchByTicker(String ticker) throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.searchByTicker(ticker).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }
}

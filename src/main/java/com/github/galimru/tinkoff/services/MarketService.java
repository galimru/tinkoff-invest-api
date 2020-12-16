package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.MarketApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.market.*;
import com.github.galimru.tinkoff.utils.ErrorUtil;
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

    public MarketInstrumentListResponse stocks() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.stocks().execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public MarketInstrumentListResponse bonds() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.bonds().execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public MarketInstrumentListResponse etfs() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.etfs().execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public MarketInstrumentListResponse currencies() throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.currencies().execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public OrderbookResponse orderbook(String figi) throws IOException, ApiException {
        return orderbook(figi, DEFAULT_ORDERBOOK_DEPTH);
    }

    public OrderbookResponse orderbook(String figi, Integer depth) throws IOException, ApiException {
        Response<OrderbookResponse> response = api.orderbook(figi, depth).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public CandlesResponse candles(String figi, Date from, Date to, CandleResolution interval) throws IOException, ApiException {
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(from, "from is null");
        Objects.requireNonNull(to, "to is null");
        Objects.requireNonNull(interval, "interval is null");

        Response<CandlesResponse> response = api.candles(figi, from, to, interval)
                .execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public SearchMarketInstrumentResponse searchByFigi(String figi) throws IOException, ApiException {
        Response<SearchMarketInstrumentResponse> response = api.searchByFigi(figi).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public MarketInstrumentListResponse searchByTicker(String ticker) throws IOException, ApiException {
        Response<MarketInstrumentListResponse> response = api.searchByTicker(ticker).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }
}

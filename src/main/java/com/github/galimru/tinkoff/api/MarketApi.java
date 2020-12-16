package com.github.galimru.tinkoff.api;

import com.github.galimru.tinkoff.json.market.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Date;

public interface MarketApi {

    @GET("market/stocks")
    Call<MarketInstrumentListResponse> stocks();

    @GET("market/bonds")
    Call<MarketInstrumentListResponse> bonds();

    @GET("market/etfs")
    Call<MarketInstrumentListResponse> etfs();

    @GET("market/currencies")
    Call<MarketInstrumentListResponse> currencies();

    @GET("market/orderbook")
    Call<OrderbookResponse> orderbook(@Query("figi") String figi, @Query("depth") Integer depth);

    @GET("market/candles")
    Call<CandlesResponse> candles(@Query("figi") String figi,
                                  @Query("from") Date from,
                                  @Query("to") Date to,
                                  @Query("interval") CandleResolution interval);

    @GET("market/search/by-figi")
    Call<SearchMarketInstrumentResponse> searchByFigi(@Query("figi") String figi);

    @GET("market/search/by-ticker")
    Call<MarketInstrumentListResponse> searchByTicker(@Query("ticker") String ticker);

}

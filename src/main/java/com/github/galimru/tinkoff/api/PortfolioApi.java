package com.github.galimru.tinkoff.api;

import com.github.galimru.tinkoff.json.portfolio.PortfolioCurrenciesResponse;
import com.github.galimru.tinkoff.json.portfolio.PortfolioResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PortfolioApi {

    @GET("portfolio")
    Call<PortfolioResponse> get(@Query("brokerAccountId") String brokerAccountId);

    @GET("portfolio/currencies")
    Call<PortfolioCurrenciesResponse> currencies(@Query("brokerAccountId") String brokerAccountId);
}

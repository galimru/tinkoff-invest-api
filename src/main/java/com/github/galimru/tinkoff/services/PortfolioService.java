package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.PortfolioApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.portfolio.PortfolioCurrenciesResponse;
import com.github.galimru.tinkoff.json.portfolio.PortfolioResponse;
import com.github.galimru.tinkoff.utils.ErrorUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class PortfolioService {

    private final PortfolioApi api;

    public PortfolioService(Retrofit retrofit) {
        this.api = retrofit.create(PortfolioApi.class);
    }

    public PortfolioResponse get() throws IOException, ApiException {
        return get(null);
    }

    public PortfolioResponse get(String brokerAccountId) throws IOException, ApiException {
        Response<PortfolioResponse> response = api.get(brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public PortfolioCurrenciesResponse getCurrencies() throws IOException, ApiException {
        return getCurrencies(null);
    }

    public PortfolioCurrenciesResponse getCurrencies(String brokerAccountId) throws IOException, ApiException {
        Response<PortfolioCurrenciesResponse> response = api.currencies(brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }
}

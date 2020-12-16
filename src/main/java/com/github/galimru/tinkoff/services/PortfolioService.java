package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.PortfolioApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.portfolio.Currencies;
import com.github.galimru.tinkoff.json.portfolio.Portfolio;
import com.github.galimru.tinkoff.json.portfolio.PortfolioCurrenciesResponse;
import com.github.galimru.tinkoff.json.portfolio.PortfolioResponse;
import com.github.galimru.tinkoff.utils.HttpUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class PortfolioService {

    private final PortfolioApi api;

    public PortfolioService(Retrofit retrofit) {
        this.api = retrofit.create(PortfolioApi.class);
    }

    public Portfolio get() throws IOException, ApiException {
        return get(null);
    }

    public Portfolio get(String brokerAccountId) throws IOException, ApiException {
        Response<PortfolioResponse> response = api.get(brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public Currencies getCurrencies() throws IOException, ApiException {
        return getCurrencies(null);
    }

    public Currencies getCurrencies(String brokerAccountId) throws IOException, ApiException {
        Response<PortfolioCurrenciesResponse> response = api.currencies(brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }
}

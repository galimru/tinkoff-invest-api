package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.SandboxApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.sandbox.*;
import com.github.galimru.tinkoff.utils.HttpUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

public class SandboxService {

    private final SandboxApi api;

    public SandboxService(Retrofit retrofit) {
        this.api = retrofit.create(SandboxApi.class);
    }

    public SandboxAccount register(BrokerAccountType brokerAccountType) throws IOException, ApiException {
        Objects.requireNonNull(brokerAccountType, "brokerAccountType is null");

        SandboxRegisterRequest request = new SandboxRegisterRequest();
        request.setBrokerAccountType(brokerAccountType);

        Response<SandboxRegisterResponse> response = api.register(request).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public void setCurrencyBalance(Currency currency, BigDecimal balance) throws IOException, ApiException {
        setCurrencyBalance(null, currency, balance);
    }

    public void setCurrencyBalance(String brokerAccountId, Currency currency, BigDecimal balance) throws IOException, ApiException {
        Objects.requireNonNull(currency, "currency is null");
        Objects.requireNonNull(balance, "balance is null");

        SandboxSetCurrencyBalanceRequest request = new SandboxSetCurrencyBalanceRequest();
        request.setCurrency(currency);
        request.setBalance(balance);

        Response<EmptyResponse> response = api.setCurrencyBalance(request, brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
    }

    public void setPositionBalance(String figi, BigDecimal balance) throws IOException, ApiException {
        setPositionBalance(null, figi, balance);
    }

    public void setPositionBalance(String brokerAccountId, String figi, BigDecimal balance) throws IOException, ApiException {
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(balance, "balance is null");

        SandboxSetPositionBalanceRequest request = new SandboxSetPositionBalanceRequest();
        request.setFigi(figi);
        request.setBalance(balance);

        Response<EmptyResponse> response = api.setPositionBalance(request, brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
    }

    public void remove() throws IOException, ApiException {
        remove(null);
    }

    public void remove(String brokerAccountId) throws IOException, ApiException {
        Response<EmptyResponse> response = api.remove(brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
    }

    public void clear() throws IOException, ApiException {
        clear(null);
    }

    public void clear(String brokerAccountId) throws IOException, ApiException {
        Response<EmptyResponse> response = api.clear(brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
    }
}

package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.SandboxApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.sandbox.SandboxRegisterRequest;
import com.github.galimru.tinkoff.json.sandbox.SandboxRegisterResponse;
import com.github.galimru.tinkoff.json.sandbox.SandboxSetCurrencyBalanceRequest;
import com.github.galimru.tinkoff.json.sandbox.SandboxSetPositionBalanceRequest;
import com.github.galimru.tinkoff.utils.ErrorUtil;
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

    public SandboxRegisterResponse register(BrokerAccountType brokerAccountType) throws IOException, ApiException {
        Objects.requireNonNull(brokerAccountType, "brokerAccountType is null");

        SandboxRegisterRequest request = new SandboxRegisterRequest();
        request.setBrokerAccountType(brokerAccountType);

        Response<SandboxRegisterResponse> response = api.register(request).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public EmptyResponse setCurrencyBalance(Currency currency, BigDecimal balance) throws IOException, ApiException {
        return setCurrencyBalance(null, currency, balance);
    }

    public EmptyResponse setCurrencyBalance(String brokerAccountId, Currency currency, BigDecimal balance) throws IOException, ApiException {
        Objects.requireNonNull(currency, "currency is null");
        Objects.requireNonNull(balance, "balance is null");

        SandboxSetCurrencyBalanceRequest request = new SandboxSetCurrencyBalanceRequest();
        request.setCurrency(currency);
        request.setBalance(balance);

        Response<EmptyResponse> response = api.setCurrencyBalance(request, brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public EmptyResponse setPositionBalance(String figi, BigDecimal balance) throws IOException, ApiException {
        return setPositionBalance(null, figi, balance);
    }

    public EmptyResponse setPositionBalance(String brokerAccountId, String figi, BigDecimal balance) throws IOException, ApiException {
        Objects.requireNonNull(figi, "figi is null");
        Objects.requireNonNull(balance, "balance is null");

        SandboxSetPositionBalanceRequest request = new SandboxSetPositionBalanceRequest();
        request.setFigi(figi);
        request.setBalance(balance);

        Response<EmptyResponse> response = api.setPositionBalance(request, brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public EmptyResponse remove() throws IOException, ApiException {
        return remove(null);
    }

    public EmptyResponse remove(String brokerAccountId) throws IOException, ApiException {
        Response<EmptyResponse> response = api.remove(brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public EmptyResponse clear() throws IOException, ApiException {
        return clear(null);
    }

    public EmptyResponse clear(String brokerAccountId) throws IOException, ApiException {
        Response<EmptyResponse> response = api.clear(brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }
}

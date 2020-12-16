package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.OrdersApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.orders.*;
import com.github.galimru.tinkoff.utils.ErrorUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Objects;

public class OrdersService {

    private final OrdersApi api;

    public OrdersService(Retrofit retrofit) {
        this.api = retrofit.create(OrdersApi.class);
    }

    public OrdersResponse get() throws IOException, ApiException {
        return get(null);
    }

    public OrdersResponse get(String brokerAccountId) throws IOException, ApiException {
        Response<OrdersResponse> response = api.get(brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public LimitOrderResponse place(LimitOrder limitOrder) throws IOException, ApiException {
        return place(null, limitOrder);
    }

    public LimitOrderResponse place(String brokerAccountId, LimitOrder limitOrder) throws IOException, ApiException {
        Objects.requireNonNull(limitOrder, "limitOrder is null");
        limitOrder.validate();

        LimitOrderRequest request = new LimitOrderRequest();
        request.setOperation(limitOrder.getType());
        request.setLots(limitOrder.getQuantity());
        request.setPrice(limitOrder.getPrice());

        Response<LimitOrderResponse> response = api.limitOrder(request, limitOrder.getFigi(), brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public MarketOrderResponse place(MarketOrder marketOrder) throws IOException, ApiException {
        return place(null, marketOrder);
    }

    public MarketOrderResponse place(String brokerAccountId, MarketOrder marketOrder) throws IOException, ApiException {
        Objects.requireNonNull(marketOrder, "marketOrder is null");
        marketOrder.validate();

        MarketOrderRequest request = new MarketOrderRequest();
        request.setOperation(marketOrder.getType());
        request.setLots(marketOrder.getQuantity());

        Response<MarketOrderResponse> response = api.marketOrder(request, marketOrder.getFigi(), brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }

    public EmptyResponse cancel(String orderId) throws IOException, ApiException {
        return cancel(null, orderId);
    }

    public EmptyResponse cancel(String brokerAccountId, String orderId) throws IOException, ApiException {
        Objects.requireNonNull(orderId, "orderId is null");

        Response<EmptyResponse> response = api.cancel(orderId, brokerAccountId).execute();

        ErrorUtil.throwErrorIfNeeded(response);
        return response.body();
    }
}

package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.OrdersApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.orders.*;
import com.github.galimru.tinkoff.utils.HttpUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class OrdersService {

    private final OrdersApi api;

    public OrdersService(Retrofit retrofit) {
        this.api = retrofit.create(OrdersApi.class);
    }

    public List<Order> get() throws IOException, ApiException {
        return get(null);
    }

    public List<Order> get(String brokerAccountId) throws IOException, ApiException {
        Response<OrdersResponse> response = api.get(brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public PlacedLimitOrder place(LimitOrder limitOrder) throws IOException, ApiException {
        return place(null, limitOrder);
    }

    public PlacedLimitOrder place(String brokerAccountId, LimitOrder limitOrder) throws IOException, ApiException {
        Objects.requireNonNull(limitOrder, "limitOrder is null");
        limitOrder.validate();

        LimitOrderRequest request = new LimitOrderRequest();
        request.setOperation(limitOrder.getType());
        request.setLots(limitOrder.getQuantity());
        request.setPrice(limitOrder.getPrice());

        Response<LimitOrderResponse> response = api.limitOrder(request, limitOrder.getFigi(), brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public PlacedMarketOrder place(MarketOrder marketOrder) throws IOException, ApiException {
        return place(null, marketOrder);
    }

    public PlacedMarketOrder place(String brokerAccountId, MarketOrder marketOrder) throws IOException, ApiException {
        Objects.requireNonNull(marketOrder, "marketOrder is null");
        marketOrder.validate();

        MarketOrderRequest request = new MarketOrderRequest();
        request.setOperation(marketOrder.getType());
        request.setLots(marketOrder.getQuantity());

        Response<MarketOrderResponse> response = api.marketOrder(request, marketOrder.getFigi(), brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }

    public void cancel(String orderId) throws IOException, ApiException {
        cancel(null, orderId);
    }

    public void cancel(String brokerAccountId, String orderId) throws IOException, ApiException {
        Objects.requireNonNull(orderId, "orderId is null");

        Response<EmptyResponse> response = api.cancel(orderId, brokerAccountId).execute();

        HttpUtil.throwErrorIfNeeded(response);
    }
}

package com.github.galimru.tinkoff.api;

import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.orders.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OrdersApi {


    @GET("orders")
    Call<OrdersResponse> get(@Query("brokerAccountId") String brokerAccountId);

    @POST("orders/limit-order")
    Call<LimitOrderResponse> limitOrder(@Body LimitOrderRequest request,
                                        @Query("figi") String figi,
                                        @Query("brokerAccountId") String brokerAccountId);

    @POST("orders/market-order")
    Call<MarketOrderResponse> marketOrder(@Body MarketOrderRequest request,
                                          @Query("figi") String figi,
                                          @Query("brokerAccountId") String brokerAccountId);

    @POST("orders/cancel")
    Call<EmptyResponse> cancel(@Query("orderId") String orderId,
                               @Query("brokerAccountId") String brokerAccountId);
}

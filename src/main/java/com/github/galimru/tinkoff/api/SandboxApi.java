package com.github.galimru.tinkoff.api;

import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.sandbox.SandboxRegisterRequest;
import com.github.galimru.tinkoff.json.sandbox.SandboxRegisterResponse;
import com.github.galimru.tinkoff.json.sandbox.SandboxSetCurrencyBalanceRequest;
import com.github.galimru.tinkoff.json.sandbox.SandboxSetPositionBalanceRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SandboxApi {

    @POST("sandbox/register")
    Call<SandboxRegisterResponse> register(@Body SandboxRegisterRequest request);

    @POST("sandbox/currencies/balance")
    Call<EmptyResponse> setCurrencyBalance(@Body SandboxSetCurrencyBalanceRequest request,
                                           @Query("brokerAccountId") String brokerAccountId);

    @POST("sandbox/positions/balance")
    Call<EmptyResponse> setPositionBalance(@Body SandboxSetPositionBalanceRequest request,
                                           @Query("brokerAccountId") String brokerAccountId);

    @POST("sandbox/remove")
    Call<EmptyResponse> remove(@Query("brokerAccountId") String brokerAccountId);

    @POST("sandbox/clear")
    Call<EmptyResponse> clear(@Query("brokerAccountId") String brokerAccountId);
}

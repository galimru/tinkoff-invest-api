package com.github.galimru.tinkoff.api;

import com.github.galimru.tinkoff.json.operations.OperationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Date;

public interface OperationsApi {

    @GET("operations")
    Call<OperationsResponse> get(@Query("from") Date from,
                                 @Query("to") Date to,
                                 @Query("figi") String figi,
                                 @Query("brokerAccountId") String brokerAccountId);
}

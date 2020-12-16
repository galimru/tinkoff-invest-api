package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.OperationsApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.operations.Operations;
import com.github.galimru.tinkoff.json.operations.OperationsResponse;
import com.github.galimru.tinkoff.utils.HttpUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class OperationsService {

    private final OperationsApi api;

    public OperationsService(Retrofit retrofit) {
        this.api = retrofit.create(OperationsApi.class);
    }

    public Operations get(Date from, Date to) throws IOException, ApiException {
        return get(null, from, to, null);
    }


    public Operations get(Date from, Date to, String figi) throws IOException, ApiException {
        return get(null, from, to, figi);
    }

    public Operations get(String brokerAccountId, Date from, Date to, String figi) throws IOException, ApiException {
        Objects.requireNonNull(from, "from is null");
        Objects.requireNonNull(to, "to is null");

        Response<OperationsResponse> response = api.get(from, to, figi, brokerAccountId)
                .execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }
}

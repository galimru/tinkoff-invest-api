package com.github.galimru.tinkoff.services;

import com.github.galimru.tinkoff.api.UserApi;
import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.user.UserAccounts;
import com.github.galimru.tinkoff.json.user.UserAccountsResponse;
import com.github.galimru.tinkoff.utils.HttpUtil;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class UserService {

    private final UserApi api;

    public UserService(Retrofit retrofit) {
        this.api = retrofit.create(UserApi.class);
    }

    public UserAccounts accounts() throws IOException, ApiException {
        Response<UserAccountsResponse> response = api.accounts().execute();

        HttpUtil.throwErrorIfNeeded(response);
        assert response.body() != null;
        return response.body().getPayload();
    }
}

package com.github.galimru.tinkoff.api;

import com.github.galimru.tinkoff.json.user.UserAccountsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("user/accounts")
    Call<UserAccountsResponse> accounts();
}

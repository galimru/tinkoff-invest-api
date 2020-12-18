package com.github.galimru.tinkoff.http;

import com.github.galimru.tinkoff.utils.HttpUtil;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private final String token;

    public AuthenticationInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String bearerToken = HttpUtil.BEARER_PREFIX + token;
        return chain.proceed(chain.request().newBuilder()
                .addHeader(HttpUtil.AUTHORIZATION_HEADER, bearerToken).build());
    }
}

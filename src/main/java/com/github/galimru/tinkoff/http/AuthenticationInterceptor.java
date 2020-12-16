package com.github.galimru.tinkoff.http;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private final static String AUTHORIZATION_HEADER = "Authorization";
    private final static String BEARER_PREFIX = "Bearer";
    private final static String WHITESPACE = " ";

    private final String token;

    public AuthenticationInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String bearerToken = BEARER_PREFIX + WHITESPACE + token;
        return chain.proceed(chain.request().newBuilder()
                .addHeader(AUTHORIZATION_HEADER, bearerToken).build());
    }
}

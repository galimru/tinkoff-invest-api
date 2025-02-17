package com.github.galimru.tinkoff.utils;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.exceptions.ServerException;
import com.github.galimru.tinkoff.json.common.Error;
import com.github.galimru.tinkoff.json.common.ErrorResponse;
import com.google.gson.Gson;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class HttpUtil {

    public final static String AUTHORIZATION_HEADER = "Authorization";
    public final static String BEARER_PREFIX = "Bearer ";

    private final static Gson gson = new Gson();

    private HttpUtil() {
    }

    public static void throwErrorIfNeeded(Response<?> response) throws ApiException {
        if (!response.isSuccessful()) {
            ResponseBody errorBody = response.errorBody();
            if (errorBody == null || errorBody.contentLength() == 0) {
                throw new ServerException(response.code(), String.format("%d %s", response.code(), response.message()));
            }
            ErrorResponse errorResponse = gson.fromJson(errorBody.charStream(), ErrorResponse.class);
            Error error = errorResponse.getPayload();
            throw new ApiException(error.getCode(), error.getMessage());
        }
    }
}

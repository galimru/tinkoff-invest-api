package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.http.AuthenticationInterceptor;
import com.github.galimru.tinkoff.http.HttpLoggingInterceptor;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.http.QueryConverterFactory;
import com.github.galimru.tinkoff.services.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Objects;

public class TinkoffInvestClient {

    public final static String PRODUCTION_BASE_URL = "https://api-invest.tinkoff.ru/openapi/";
    public final static String SANDBOX_BASE_URL = "https://api-invest.tinkoff.ru/openapi/sandbox/";
    public final static String STREAMING_BASE_URL = "wss://api-invest.tinkoff.ru/openapi/md/v1/md-openapi/ws";

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSSSSSXXX";
    private static final String SANDBOX_PATH = "/sandbox";

    private final SandboxService sandboxService;
    private final OrdersService ordersService;
    private final PortfolioService portfolioService;
    private final MarketService marketService;
    private final OperationsService operationsService;
    private final UserService userService;

    private final boolean isSandbox;

    public static TinkoffInvestClient create(String token) {
        return create(token, false);
    }

    public static TinkoffInvestClient create(String token, boolean sandbox) {
        return builder()
                .withBaseUrl(sandbox ? SANDBOX_BASE_URL : PRODUCTION_BASE_URL)
                .withToken(token)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    private TinkoffInvestClient(Builder builder) {
        OkHttpClient client = builder.httpClient.newBuilder()
                .addInterceptor(new AuthenticationInterceptor(builder.token))
                .addNetworkInterceptor(new HttpLoggingInterceptor(builder.httpLoggingLevel))
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(builder.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(QueryConverterFactory.create())
                .build();

        sandboxService = new SandboxService(retrofit);
        ordersService = new OrdersService(retrofit);
        portfolioService = new PortfolioService(retrofit);
        marketService = new MarketService(retrofit);
        operationsService = new OperationsService(retrofit);
        userService = new UserService(retrofit);

        isSandbox = builder.baseUrl
                .toLowerCase()
                .contains(SANDBOX_PATH);
    }

    public boolean isSandbox() {
        return isSandbox;
    }

    public SandboxService sandbox() {
        if (!isSandbox) {
            throw new IllegalStateException("Cannot access sandbox service in production mode");
        }
        return sandboxService;
    }

    public OrdersService orders() {
        return ordersService;
    }

    public PortfolioService portfolio() {
        return portfolioService;
    }

    public MarketService market() {
        return marketService;
    }

    public OperationsService operations() {
        return operationsService;
    }

    public UserService user() {
        return userService;
    }

    public static class Builder {

        private OkHttpClient httpClient = new OkHttpClient();
        private String baseUrl = PRODUCTION_BASE_URL;
        private String token;
        private Level httpLoggingLevel = Level.NONE;

        public Builder withBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public Builder withHttpClient(OkHttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder withHttpLoggingLevel(Level httpLoggingLevel) {
            this.httpLoggingLevel = httpLoggingLevel;
            return this;
        }

        public TinkoffInvestClient build() {
            Objects.requireNonNull(baseUrl, "baseUrl is null");
            Objects.requireNonNull(token, "token is null");
            Objects.requireNonNull(httpClient, "httpClient is null");
            Objects.requireNonNull(httpLoggingLevel, "httpLoggingLevel is null");
            return new TinkoffInvestClient(this);
        }
    }
}

package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.orders.LimitOrderResponse;
import com.github.galimru.tinkoff.json.orders.MarketOrderResponse;
import com.github.galimru.tinkoff.json.orders.OrdersResponse;
import com.github.galimru.tinkoff.services.LimitOrder;
import com.github.galimru.tinkoff.services.MarketOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class OrdersServiceTest {

    private TinkoffInvestClient client;

    @Before
    public void setup() {
        client = TinkoffInvestClient.builder()
                .withBaseUrl(TinkoffInvestClient.SANDBOX_BASE_URL)
                .withToken(TestConstants.TOKEN)
                .withHttpLoggingLevel(Level.BASIC)
                .build();
    }

    @Test
    public void getShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        OrdersResponse response = client
                .orders()
                .get();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void limitOrderShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setCurrencyBalance(Currency.USD, new BigDecimal("5000"));
        LimitOrderResponse response = client
                .orders()
                .place(LimitOrder
                        .buy(TestConstants.SPCE_FIGI)
                        .quantity(10)
                        .price(new BigDecimal("23.4")));
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void marketOrderShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setCurrencyBalance(Currency.USD, new BigDecimal("5000"));
        MarketOrderResponse response = client
                .orders()
                .place(MarketOrder
                        .buy(TestConstants.SPCE_FIGI)
                        .quantity(10));
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    @Ignore("It's not possible to cancel order since they executed immediately on sandbox")
    public void cancelShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setCurrencyBalance(Currency.USD, new BigDecimal("5000"));
        LimitOrderResponse orderResponse = client
                .orders()
                .place(LimitOrder
                        .buy(TestConstants.SPCE_FIGI)
                        .quantity(10)
                        .price(new BigDecimal("10")));
        EmptyResponse response = client
                .orders()
                .cancel(orderResponse.getPayload().getOrderId());
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

}

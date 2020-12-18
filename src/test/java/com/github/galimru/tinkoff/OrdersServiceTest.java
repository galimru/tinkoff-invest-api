package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.orders.Order;
import com.github.galimru.tinkoff.json.orders.PlacedLimitOrder;
import com.github.galimru.tinkoff.json.orders.PlacedMarketOrder;
import com.github.galimru.tinkoff.services.LimitOrder;
import com.github.galimru.tinkoff.services.MarketOrder;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class OrdersServiceTest {

    private static TinkoffInvestClient client;

    @BeforeClass
    public static void setup() throws IOException, ApiException {
        client = TinkoffInvestClient.builder()
                .withBaseUrl(TinkoffInvestClient.SANDBOX_BASE_URL)
                .withToken(TestConstants.TOKEN)
                .withHttpLoggingLevel(Level.BASIC)
                .build();
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setCurrencyBalance(Currency.USD, new BigDecimal("5000"));
    }

    @AfterClass
    public static void destroy() throws IOException, ApiException {
        client.sandbox().clear();
    }

    @After
    public void after() throws InterruptedException {
        // delay each test to avoid error 429 Too Many Requests
        Thread.sleep(TestConstants.TESTS_DELAY);
    }

    @Test
    public void getShouldReturnOk() throws IOException, ApiException {
        List<Order> orders = client
                .orders()
                .get();
        Assert.assertNotNull(orders);
    }

    @Test
    public void limitOrderShouldReturnOk() throws IOException, ApiException {
        PlacedLimitOrder placedOrder = client
                .orders()
                .place(LimitOrder
                        .buy(TestConstants.SPCE_FIGI)
                        .quantity(10)
                        .price(new BigDecimal("23.4")));
        Assert.assertNotNull(placedOrder);
    }

    @Test
    public void marketOrderShouldReturnOk() throws IOException, ApiException {
        PlacedMarketOrder placedOrder = client
                .orders()
                .place(MarketOrder
                        .buy(TestConstants.SPCE_FIGI)
                        .quantity(10));
        Assert.assertNotNull(placedOrder);
    }

    @Test
    @Ignore("It's not possible to cancel order since they executed immediately on sandbox")
    public void cancelShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setCurrencyBalance(Currency.USD, new BigDecimal("5000"));
        PlacedLimitOrder placedOrder = client
                .orders()
                .place(LimitOrder
                        .buy(TestConstants.SPCE_FIGI)
                        .quantity(10)
                        .price(new BigDecimal("10")));
        client.orders()
                .cancel(placedOrder.getOrderId());
    }

}

package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.market.CandleResolution;
import com.github.galimru.tinkoff.services.streaming.CandleSubscription;
import com.github.galimru.tinkoff.services.streaming.InstrumentInfoSubscription;
import com.github.galimru.tinkoff.services.streaming.OrderbookSubscription;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

public class StreamingServiceTest {

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
    public void candleSubscriptionShouldBeInvoked() throws InterruptedException {
        AtomicBoolean invoked = new AtomicBoolean();
        client.streaming().addCandleListener(event -> {
            System.out.println(event);
            invoked.set(true);
            Assert.assertNotNull(event);
        });
        client.streaming().subscribe(
                CandleSubscription
                        .on(TestConstants.SPCE_FIGI)
                        .withInterval(CandleResolution.ONE_MINUTE));
        Thread.sleep(5000);
        Assert.assertTrue(invoked.get());
    }

    @Test
    @Ignore("It doesn't receive events when stock exchange closed")
    public void orderbookSubscriptionShouldBeInvoked() throws InterruptedException {
        AtomicBoolean invoked = new AtomicBoolean();
        client.streaming().addOrderbookListener(event -> {
            System.out.println(event);
            invoked.set(true);
            Assert.assertNotNull(event);
        });
        client.streaming().subscribe(
                OrderbookSubscription
                        .on(TestConstants.SPCE_FIGI)
                        .withDepth(20));
        Thread.sleep(5000);
        Assert.assertTrue(invoked.get());
    }

    @Test
    public void instrumentInfoSubscriptionShouldBeInvoked() throws InterruptedException {
        AtomicBoolean invoked = new AtomicBoolean();
        client.streaming().addInstrumentInfoListener(event -> {
            System.out.println(event);
            invoked.set(true);
            Assert.assertNotNull(event);
        });
        client.streaming().subscribe(
                InstrumentInfoSubscription
                        .on(TestConstants.SPCE_FIGI));
        Thread.sleep(5000);
        Assert.assertTrue(invoked.get());
    }

    @Test
    public void twoSubscriptionsShouldBeInvoked() throws InterruptedException {
        // subscription on candle
        AtomicBoolean candleInvoked = new AtomicBoolean();
        client.streaming().addCandleListener(event -> {
            System.out.println(event);
            candleInvoked.set(true);
            Assert.assertNotNull(event);
        });
        client.streaming().subscribe(
                CandleSubscription
                        .on(TestConstants.SPCE_FIGI)
                        .withInterval(CandleResolution.FIVE_MINUTES));
        // subscription on instrument info
        AtomicBoolean instrumentInfoInvoked = new AtomicBoolean();
        client.streaming().addInstrumentInfoListener(event -> {
            System.out.println(event);
            instrumentInfoInvoked.set(true);
            Assert.assertNotNull(event);
        });
        client.streaming().subscribe(
                InstrumentInfoSubscription
                        .on(TestConstants.SPCE_FIGI));

        Thread.sleep(5000);
        Assert.assertTrue(candleInvoked.get());
        Assert.assertTrue(instrumentInfoInvoked.get());
    }

}

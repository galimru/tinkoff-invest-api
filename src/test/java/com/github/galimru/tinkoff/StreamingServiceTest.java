package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.market.CandleResolution;
import com.github.galimru.tinkoff.services.streaming.CandleSubscription;
import com.github.galimru.tinkoff.services.streaming.InstrumentInfoSubscription;
import com.github.galimru.tinkoff.services.streaming.OrderbookSubscription;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class StreamingServiceTest {

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

}

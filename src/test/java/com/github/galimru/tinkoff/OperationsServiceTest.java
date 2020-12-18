package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.operations.Operations;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class OperationsServiceTest {

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
    @Ignore("api works unstable and might return errors")
    public void getShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        Operations operations = client.operations().get(
                Date.from(Instant.now().minus(1, ChronoUnit.DAYS)),
                Date.from(Instant.now()));
        Assert.assertNotNull(operations);
    }

}

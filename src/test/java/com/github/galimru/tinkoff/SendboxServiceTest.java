package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.sandbox.SandboxAccount;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;

public class SendboxServiceTest {

    private static TinkoffInvestClient client;

    @BeforeClass
    public static void setup() throws IOException, ApiException {
        client = TinkoffInvestClient.builder()
                .withBaseUrl(TinkoffInvestClient.SANDBOX_BASE_URL)
                .withToken(TestConstants.TOKEN)
                .withHttpLoggingLevel(Level.BASIC)
                .build();
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
    public void registerShouldReturnOk() throws IOException, ApiException {
        SandboxAccount account = client.sandbox()
                .register(BrokerAccountType.TINKOFF);
        Assert.assertNotNull(account);
    }

    @Test
    public void setCurrencyBalanceShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setCurrencyBalance(Currency.USD, new BigDecimal("54.34"));
    }

    @Test
    public void setPositionBalanceShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().setPositionBalance(TestConstants.SPCE_FIGI, new BigDecimal("54.34"));
    }

    @Test
    public void removeShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().remove();
    }

    @Test
    public void clearShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        client.sandbox().clear();
    }

}

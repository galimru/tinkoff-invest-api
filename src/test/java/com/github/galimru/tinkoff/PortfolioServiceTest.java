package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.portfolio.Currencies;
import com.github.galimru.tinkoff.json.portfolio.Portfolio;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;

public class PortfolioServiceTest {

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
        Portfolio portfolio = client
                .portfolio()
                .get();
        Assert.assertNotNull(portfolio);
    }

    @Test
    public void currenciesShouldReturnOk() throws IOException, ApiException {
        Currencies currencies = client.portfolio()
                .currencies();
        Assert.assertNotNull(currencies);
    }

}

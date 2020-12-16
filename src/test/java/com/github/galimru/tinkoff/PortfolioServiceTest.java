package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.portfolio.Currencies;
import com.github.galimru.tinkoff.json.portfolio.Portfolio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class PortfolioServiceTest {

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
        Portfolio portfolio = client
                .portfolio()
                .get();
        Assert.assertNotNull(portfolio);
    }

    @Test
    public void getCurrenciesShouldReturnOk() throws IOException, ApiException {
        Currencies currencies = client.portfolio()
                .getCurrencies();
        Assert.assertNotNull(currencies);
    }

}

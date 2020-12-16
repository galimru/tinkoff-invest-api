package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.portfolio.PortfolioCurrenciesResponse;
import com.github.galimru.tinkoff.json.portfolio.PortfolioResponse;
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
        PortfolioResponse response = client
                .portfolio()
                .get();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void getCurrenciesShouldReturnOk() throws IOException, ApiException {
        PortfolioCurrenciesResponse response = client.portfolio()
                .getCurrencies();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

}

package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.common.EmptyResponse;
import com.github.galimru.tinkoff.json.sandbox.SandboxRegisterResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class SendboxServiceTest {

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
    public void registerShouldCreateBrokerAccount() throws IOException, ApiException {
        SandboxRegisterResponse response = client.sandbox()
                .register(BrokerAccountType.TINKOFF);
        Assert.assertEquals(TestConstants.OK, response.getStatus());
        Assert.assertNotNull(response.getPayload().getBrokerAccountId());
    }

    @Test
    public void setCurrencyBalanceShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        EmptyResponse response = client
                .sandbox()
                .setCurrencyBalance(Currency.USD, new BigDecimal("54.34"));
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void setPositionBalanceShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        EmptyResponse response = client
                .sandbox()
                .setPositionBalance(TestConstants.SPCE_FIGI, new BigDecimal("54.34"));
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void removeShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        EmptyResponse response = client
                .sandbox()
                .remove();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void clearShouldReturnOk() throws IOException, ApiException {
        client.sandbox().register(BrokerAccountType.TINKOFF);
        EmptyResponse response = client
                .sandbox()
                .clear();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

}

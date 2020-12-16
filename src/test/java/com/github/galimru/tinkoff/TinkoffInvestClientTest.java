package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.market.MarketInstrumentList;
import com.github.galimru.tinkoff.services.LimitOrder;
import com.github.galimru.tinkoff.services.MarketOrder;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class TinkoffInvestClientTest {

    @Test(expected = IllegalStateException.class)
    public void sandboxShouldThrowExceptionWhenUseProductionBaseUrl() {
        TinkoffInvestClient client = TinkoffInvestClient.builder()
                .withBaseUrl(TinkoffInvestClient.PRODUCTION_BASE_URL)
                .withToken(TestConstants.TOKEN)
                .build();

        client.sandbox();
    }

    @Test
    public void deadSimpleExample() throws IOException, ApiException {
        // create api client for sandbox environment
        TinkoffInvestClient client = TinkoffInvestClient.create(TestConstants.TOKEN, true);
        // register new sandbox broker account
        client.sandbox()
                .register(BrokerAccountType.TINKOFF);
        // set broker account balance to $1000.55
        client.sandbox()
                .setCurrencyBalance(Currency.USD, BigDecimal.valueOf(1000.55));
        // search figi by ticker TSLA (Tesla)
        MarketInstrumentList resultList = client.market()
                .searchByTicker("TSLA");
        String figi = resultList.getInstruments().get(0).getFigi();
        // buy 1 lot of Tesla using market order
        client.orders()
                .place(MarketOrder
                        .buy(figi)
                        .quantity(1));
        // sell 1 lot of Tesla using limit order
        client.orders()
                .place(LimitOrder
                        .sell(figi)
                        .quantity(1)
                        .price(BigDecimal.valueOf(800.45)));
        // clear all sandbox accounts
        client.sandbox()
                .clear();
    }

}

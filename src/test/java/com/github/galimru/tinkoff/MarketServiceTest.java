package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.market.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarketServiceTest {

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
    public void stocksShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentListResponse response = client.market().stocks();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void bondsShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentListResponse response = client.market().bonds();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void etfsShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentListResponse response = client.market().etfs();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void currenciesShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentListResponse response = client.market().currencies();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void orderbookShouldReturnOk() throws IOException, ApiException {
        OrderbookResponse response = client.market().orderbook(TestConstants.SPCE_FIGI);
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void candlesShouldReturnOk() throws IOException, ApiException, ParseException {
        CandlesResponse response = client.market().candles(
                TestConstants.SPCE_FIGI,
                convertToDate("01/12/2020 10:00"),
                convertToDate("02/12/2020 10:00"),
                CandleResolution.HOUR);
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void searchByFigiShouldReturnOk() throws IOException, ApiException {
        SearchMarketInstrumentResponse response = client.market().searchByFigi(TestConstants.SPCE_FIGI);
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    @Test
    public void searchByTickerShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentListResponse response = client.market().searchByTicker(TestConstants.SPCE_TICKER);
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

    private Date convertToDate(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat.parse(str);
    }
}

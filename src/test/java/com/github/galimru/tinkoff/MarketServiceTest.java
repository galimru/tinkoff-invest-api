package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.market.*;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarketServiceTest {

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
    public void stocksShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentList stocks = client.market().stocks();
        Assert.assertNotNull(stocks);
    }

    @Test
    public void bondsShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentList bounds = client.market().bonds();
        Assert.assertNotNull(bounds);
    }

    @Test
    public void etfsShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentList etfs = client.market().etfs();
        Assert.assertNotNull(etfs);
    }

    @Test
    public void currenciesShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentList currencies = client.market().currencies();
        Assert.assertNotNull(currencies);
    }

    @Test
    public void orderbookShouldReturnOk() throws IOException, ApiException {
        Orderbook orderbook = client.market().orderbook(TestConstants.SPCE_FIGI);
        Assert.assertNotNull(orderbook);
    }

    @Test
    public void candlesShouldReturnOk() throws IOException, ApiException, ParseException {
        Candles candles = client.market().candles(
                TestConstants.SPCE_FIGI,
                convertToDate("01/12/2020 10:00"),
                convertToDate("02/12/2020 10:00"),
                CandleResolution.HOUR);
        Assert.assertNotNull(candles);
    }

    @Test
    public void searchByFigiShouldReturnOk() throws IOException, ApiException {
        SearchMarketInstrument instrument = client.market().searchByFigi(TestConstants.SPCE_FIGI);
        Assert.assertNotNull(instrument);
    }

    @Test
    public void searchByTickerShouldReturnOk() throws IOException, ApiException {
        MarketInstrumentList tickers = client.market().searchByTicker(TestConstants.SPCE_TICKER);
        Assert.assertNotNull(tickers);
    }

    private Date convertToDate(String str) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat.parse(str);
    }
}

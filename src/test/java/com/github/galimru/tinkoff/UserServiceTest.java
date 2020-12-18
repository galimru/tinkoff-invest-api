package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.common.BrokerAccountType;
import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.user.UserAccounts;
import org.junit.*;

import java.io.IOException;
import java.math.BigDecimal;

public class UserServiceTest {

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
    public void accountsShouldReturnOk() throws IOException, ApiException {
        UserAccounts accounts = client.user().accounts();
        Assert.assertNotNull(accounts);
    }

}

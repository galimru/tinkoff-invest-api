package com.github.galimru.tinkoff;

import com.github.galimru.tinkoff.exceptions.ApiException;
import com.github.galimru.tinkoff.http.Level;
import com.github.galimru.tinkoff.json.user.UserAccountsResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class UserServiceTest {

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
    public void accountsShouldReturnOk() throws IOException, ApiException {
        UserAccountsResponse response = client.user().accounts();
        Assert.assertEquals(TestConstants.OK, response.getStatus());
    }

}

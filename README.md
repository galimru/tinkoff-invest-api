# tinkoff-invest-api
Tinkoff Invest client written on Java

---

### Dead simple example

```java
    // create api client for sandbox environment
    TinkoffInvestClient client = TinkoffInvestClient.create(TestConstants.TOKEN, true);
    // register new sandbox broker account
    client.sandbox()
            .register(BrokerAccountType.TINKOFF);
    // set broker account balance to $1000.55
    client.sandbox()
            .setCurrencyBalance(Currency.USD, BigDecimal.valueOf(1000.55));
    // search figi by ticker TSLA (Tesla)
    MarketInstrumentListResponse searchResponse = client.market()
            .searchByTicker("TSLA");
    String figi = searchResponse.getPayload().getInstruments().get(0).getFigi();
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
```

## Links

[Swagger API](https://tinkoffcreditsystems.github.io/invest-openapi/swagger-ui/)

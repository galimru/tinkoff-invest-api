# 🚀 tinkoff-invest-api

[![](https://jitpack.io/v/galimru/tinkoff-invest-api.svg)](https://jitpack.io/#galimru/tinkoff-invest-api)
[![Build Status](https://travis-ci.org/galimru/tinkoff-invest-api.svg?branch=main)](https://travis-ci.org/galimru/tinkoff-invest-api)
[![Gitter](https://badges.gitter.im/galimru/tinkoff-invest-api.svg)](https://gitter.im/galimru/tinkoff-invest-api)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Tinkoff Invest client written on Java.

---

## Installation

Import the library to your project using [jitpack](https://jitpack.io/#galimru/tinkoff-invest-api/1.1.5) repository 

#### Gradle

  1. Add the JitPack repository to your build file
  
```gradle
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

  2. Add the tinkoff-invest-api library dependency

```gradle
implementation 'com.github.galimru:tinkoff-invest-api:1.1.5'
```

_Note: The JitPack supports both Gradle/Maven build tools, please refer to jitpack [documentation](https://jitpack.io/#galimru/tinkoff-invest-api) if you want use Maven_


## Dead simple example

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
        // add streaming listener for candle events
        client.streaming()
                .addCandleListener(event ->
                        System.out.println("High: " + event.getHigh()));
        // subscribe on candle events for TSLA
        client.streaming()
                .subscribe(CandleSubscription
                        .on(figi)
                        .withInterval(CandleResolution.FIVE_MINUTES));
        // clear all sandbox accounts
        client.sandbox()
                .clear();
```

## License

Apache License 2.0

_Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License._


## Links

[OpenAPI Documentation](https://tinkoffcreditsystems.github.io/invest-openapi/)

[Swagger API](https://tinkoffcreditsystems.github.io/invest-openapi/swagger-ui/)

[Official OpenAPI Java SDK](https://github.com/TinkoffCreditSystems/invest-openapi-java-sdk)

package com.github.galimru.tinkoff.json.user;

import com.github.galimru.tinkoff.json.common.BrokerAccountType;

public class UserAccount {

    private BrokerAccountType brokerAccountType;
    private String brokerAccountId;

    public BrokerAccountType getBrokerAccountType() {
        return brokerAccountType;
    }

    public void setBrokerAccountType(BrokerAccountType brokerAccountType) {
        this.brokerAccountType = brokerAccountType;
    }

    public String getBrokerAccountId() {
        return brokerAccountId;
    }

    public void setBrokerAccountId(String brokerAccountId) {
        this.brokerAccountId = brokerAccountId;
    }
}
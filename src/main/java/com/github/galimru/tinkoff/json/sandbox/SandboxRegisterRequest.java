package com.github.galimru.tinkoff.json.sandbox;

import com.github.galimru.tinkoff.json.common.BrokerAccountType;

public class SandboxRegisterRequest {

    private BrokerAccountType brokerAccountType;

    public BrokerAccountType getBrokerAccountType() {
        return brokerAccountType;
    }

    public void setBrokerAccountType(BrokerAccountType brokerAccountType) {
        this.brokerAccountType = brokerAccountType;
    }
}

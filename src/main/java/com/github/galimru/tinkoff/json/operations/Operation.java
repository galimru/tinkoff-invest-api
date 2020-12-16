package com.github.galimru.tinkoff.json.operations;

import com.github.galimru.tinkoff.json.common.Currency;
import com.github.galimru.tinkoff.json.common.InstrumentType;
import com.github.galimru.tinkoff.json.common.MoneyAmount;
import com.github.galimru.tinkoff.json.common.OperationType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Operation {

    private String id;
    private OperationStatus status;
    private List<OperationTrade> trades;
    private MoneyAmount commission;
    private Currency currency;
    private BigDecimal payment;
    private BigDecimal price;
    private Integer quantity;
    private Integer quantityExecuted;
    private String figi;
    private InstrumentType instrumentType;
    private Boolean isMarginCall;
    private Date date;
    private OperationType operationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public List<OperationTrade> getTrades() {
        return trades;
    }

    public void setTrades(List<OperationTrade> trades) {
        this.trades = trades;
    }

    public MoneyAmount getCommission() {
        return commission;
    }

    public void setCommission(MoneyAmount commission) {
        this.commission = commission;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityExecuted() {
        return quantityExecuted;
    }

    public void setQuantityExecuted(Integer quantityExecuted) {
        this.quantityExecuted = quantityExecuted;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public Boolean getMarginCall() {
        return isMarginCall;
    }

    public void setMarginCall(Boolean marginCall) {
        isMarginCall = marginCall;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}

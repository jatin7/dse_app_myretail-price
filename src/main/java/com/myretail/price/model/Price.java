package com.myretail.price.model;

public class Price {

    Double value;
    String currencyCode;

    public Price() {
    }

    public Price(Double value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public String getCurrencyCode() {
        return currencyCode;
    }
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    @Override
    public String toString() {
        return "Price [value=" + value + ", currencyCode=" + currencyCode + "]";
    }

}

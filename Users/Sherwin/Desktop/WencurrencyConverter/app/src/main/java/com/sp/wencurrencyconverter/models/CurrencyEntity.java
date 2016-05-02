package com.sp.wencurrencyconverter.models;

import com.sp.wencurrencyconverter.enums.CurrencyCode;

/**
 * Created by Sherwin on 4/29/2016.
 */
public class CurrencyEntity {

    private String currencySymbol;
    private String currencyValue;
    private String country;
    private int    countryThumb;

    public CurrencyEntity(String currencySymbol, String currencyValue, String country,int countryThumb) {
        this.currencySymbol = currencySymbol;
        this.currencyValue = currencyValue;
        this.country = country;
        this.countryThumb = countryThumb;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(String currencyValue) {
        this.currencyValue = currencyValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCountryThumb() {
        return countryThumb;
    }

    public void setCountryThumb(int countryThumb) {
        this.countryThumb = countryThumb;
    }
}

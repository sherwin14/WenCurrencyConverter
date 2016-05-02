package com.sp.wencurrencyconverter;

/**
 * Created by Sherwin on 4/26/2016.
 */
public class Constants {

    // Database constants
    public final static String DATABASE_NAME="wen_currency_db";

    //Table rates
    public final static String DATABASE_TABLE_RATES="rates";

    //columns
    public final static String COLUMN_ID="id";
    public final static String COLUMN_based_id="base_id";
    public final static String COLUMN_AUD="AUD";
    public final static String COLUMN_BGN="BGN";
    public final static String COLUMN_BRL="BRL";
    public final static String COLUMN_CAD="CAD";
    public final static String COLUMN_CHF="CHF";
    public final static String COLUMN_CNY="CNY";
    public final static String COLUMN_CZK="CZK";
    public final static String COLUMN_DKK="DKK";
    public final static String COLUMN_GBP="GBP";
    public final static String COLUMN_HKD="HKD";
    public final static String COLUMN_HRK="HRK";
    public final static String COLUMN_HUF="HUF";
    public final static String COLUMN_IDR="IDR";
    public final static String COLUMN_ILS="ILS";
    public final static String COLUMN_INR="INR";
    public final static String COLUMN_JPY="JPY";
    public final static String COLUMN_KRW="KRW";
    public final static String COLUMN_MXN="MXN";
    public final static String COLUMN_MYR="MYR";
    public final static String COLUMN_NOK="NOK";
    public final static String COLUMN_NZD="NZD";
    public final static String COLUMN_PLN="PLN";
    public final static String COLUMN_RON="RON";
    public final static String COLUMN_RUB="RUB";
    public final static String COLUMN_SEK="SEK";
    public final static String COLUMN_SGD="SGD";
    public final static String COLUMN_THB="THB";
    public final static String COLUMN_TRY="TRY";
    public final static String COLUMN_USD="USD";
    public final static String COLUMN_ZAR="ZAR";
    public final static String COLUMN_EUR="EUR";


    //Tables base
    public static final String DATABASE_BASE="base";

    //columns
    public static final String COLUMN_BASE_ID="base_id";
    public static final String COLUMN_BASE_DATE="date";
    public static final String COLUMN_BASE_CODE="base";

    public static final String CURRENCY_COLUMN_ID = "id";
    public static final String CURRENCY_COLUMN_CURRENCY_CODE = "country_code";
    public static final String CURRENCY_COLUMN_BASE = "base";
    public static final String CURRENCY_COLUMN_RATES = "rate";
    public static final String CURRENCY_COLUMN_LAST_UPDATE= "date";
    public final static int    DATABASE_VERSION=1;

    //URL for getting country code
    public final static String URL_COUNTRY="http://ip-api.com/json";

    //Default URL for currency
    public final static String URL_CURRENCY="http://api.fixer.io/";
}

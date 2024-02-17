package com.interview.task.deals.constants;

import java.util.Arrays;
import java.util.Currency;

public class DealConstants {

    public static final String DEAL_CREATED = "Deal details created successfully";
    public static final String[] CURRENCY = Currency.getAvailableCurrencies().stream().map(e -> e.getCurrencyCode())
            .toArray(String[]::new);

}
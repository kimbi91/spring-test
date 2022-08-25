package hu.progmatic.springtest.service;

import hu.progmatic.springtest.model.Currency;

public interface CurrencyConverter {
    double convert(Currency base, Currency quote, double amount);
}

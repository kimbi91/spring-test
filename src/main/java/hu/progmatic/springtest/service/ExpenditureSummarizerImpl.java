package hu.progmatic.springtest.service;

import hu.progmatic.springtest.model.Category;
import hu.progmatic.springtest.model.Currency;
import hu.progmatic.springtest.model.Expenditure;

import java.time.LocalDate;
import java.util.List;


public class ExpenditureSummarizerImpl implements ExpenditureSummarizer{

    private final ExpenditureStorage expenditureStorage;

    private final CurrencyConverter currencyConverter;

    public ExpenditureSummarizerImpl(
            ExpenditureStorage expenditureStorage,
            CurrencyConverter currencyConverter
    ) {
        this.expenditureStorage = expenditureStorage;
        this.currencyConverter = currencyConverter;
    }

    public double getExpenditureSum(Currency curreny) {
        List<Expenditure> expenditures = expenditureStorage.loadExpenditures();

        double sum = 0.0;

        for (Expenditure expenditure : expenditures) {
            sum += currencyConverter.convert(
                    expenditure.getCurrency(),
                    curreny,
                    expenditure.getAmount()
            );
        }

        return sum;
    }

    public double getExpenditureSum(
            Currency curreny,
            Category category
    ) {
       throw new UnsupportedOperationException();
    }

    public double getExpenditureSum(
            Currency curreny,
            LocalDate dateFrom,
            LocalDate dateTo
    ) {
        throw new UnsupportedOperationException();
    }
}

package hu.progmatic.springtest.service;

import hu.progmatic.springtest.model.Category;
import hu.progmatic.springtest.model.Currency;
import hu.progmatic.springtest.model.Expenditure;

import java.time.LocalDate;
import java.util.List;

public interface ExpenditureSummarizer {
    double getExpenditureSum(Currency curreny);

    double getExpenditureSum(
            Currency curreny,
            Category category
    );

    double getExpenditureSum(
            Currency curreny,
            LocalDate dateFrom,
            LocalDate dateTo
    );
}

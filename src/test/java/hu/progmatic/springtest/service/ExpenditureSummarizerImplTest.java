package hu.progmatic.springtest.service;

import hu.progmatic.springtest.model.Category;
import hu.progmatic.springtest.model.Currency;
import hu.progmatic.springtest.model.Expenditure;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenditureSummarizerImplTest {

    @Test
    void getExpenditureSum() {
        ExpenditureStorage expenditureStorage = new ExpenditureStorage() {
            @Override
            public List<Expenditure> loadExpenditures() {
                return List.of(
                        new Expenditure(LocalDate.now(), Category.LEISURE, Currency.HUF, 50000),
                        new Expenditure(LocalDate.now(), Category.LEISURE, Currency.EUR, 100)
                );
            }
        };

        CurrencyConverter currencyConverter = new CurrencyConverter() {
            @Override
            public double convert(Currency base, Currency quote, double amount) {
                return switch (base) {
                    case HUF -> amount;
                    case EUR -> amount * 500;
                    default -> throw new IllegalStateException();
                };
            }
        };

        ExpenditureSummarizer expenditureSummarizer = new ExpenditureSummarizerImpl(
                expenditureStorage,
                currencyConverter
        );

        double sum = expenditureSummarizer.getExpenditureSum(Currency.HUF);

        assertEquals(100000.0, sum);
    }

    /*@Test
    void testGetExpenditureSum() {
    }

    @Test
    void testGetExpenditureSum1() {
    }*/
}
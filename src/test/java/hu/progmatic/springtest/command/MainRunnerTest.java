package hu.progmatic.springtest.command;

import hu.progmatic.springtest.model.Category;
import hu.progmatic.springtest.model.Currency;
import hu.progmatic.springtest.service.ExpenditureSummarizer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class MainRunnerTest {

    @Test
    void run() throws Exception {
        ExpenditureSummarizer expenditureSummarizer = new ExpenditureSummarizer() {
            @Override
            public double getExpenditureSum(Currency curreny) {
                return 10000.0;
            }

            @Override
            public double getExpenditureSum(Currency curreny, Category category) {
                return 5000.0;
            }

            @Override
            public double getExpenditureSum(Currency curreny, LocalDate dateFrom, LocalDate dateTo) {
                return 2500.0;
            }
        };

        MainRunner mainRunner = new MainRunner(expenditureSummarizer);
        mainRunner.run();
    }
}
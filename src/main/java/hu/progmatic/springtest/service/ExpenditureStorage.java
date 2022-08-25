package hu.progmatic.springtest.service;

import hu.progmatic.springtest.model.Expenditure;

import java.util.List;

public interface ExpenditureStorage {
    List<Expenditure> loadExpenditures();
}

package hu.progmatic.springtest.model;

import java.time.LocalDate;
import java.util.Objects;

public class Expenditure {
    private Long id;
    private LocalDate date;
    private Category category;
    private Currency currency;
    private double amount;

    public Expenditure() {
    }

    public Expenditure(LocalDate date, Category category, Currency currency, double amount) {
        this.date = date;
        this.category = category;
        this.currency = currency;
        this.amount = amount;
    }

    public Expenditure(Long id, LocalDate date, Category category, Currency currency, double amount) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.currency = currency;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expenditure)) return false;
        Expenditure that = (Expenditure) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Expenditure{" +
                "id=" + id +
                ", date=" + date +
                ", category=" + category +
                ", currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}

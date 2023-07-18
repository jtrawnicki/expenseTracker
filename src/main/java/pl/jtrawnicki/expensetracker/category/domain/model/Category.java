package pl.jtrawnicki.expensetracker.category.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import pl.jtrawnicki.expensetracker.expense.domain.model.Expense;

import java.util.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Expense> expenses;

    public Category() {
        this.id = UUID.randomUUID();
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    public Category addExpense(Expense expense) {
        if (expenses == null) {
            expenses = new ArrayList<>();
        }

        expenses.add(expense);
        expense.setCategory(this);

        return this;

    }

    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expenses=" + expenses +
                '}';
    }
}

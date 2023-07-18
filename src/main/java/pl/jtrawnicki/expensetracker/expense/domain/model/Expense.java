package pl.jtrawnicki.expensetracker.expense.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import pl.jtrawnicki.expensetracker.category.domain.model.Category;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    private UUID id;

    private String name;

    private BigDecimal value;

    @ManyToOne
    private Category category;

    public Expense() {
        this.id = UUID.randomUUID();
    }

    public Expense(String name, BigDecimal value) {
        this();
        this.name = name;
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", category=" + category +
                '}';
    }
}

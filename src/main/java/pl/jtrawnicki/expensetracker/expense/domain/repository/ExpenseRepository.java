package pl.jtrawnicki.expensetracker.expense.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jtrawnicki.expensetracker.expense.domain.model.Expense;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    public List<Expense> findAllByCategoryId(UUID categoryId);
}

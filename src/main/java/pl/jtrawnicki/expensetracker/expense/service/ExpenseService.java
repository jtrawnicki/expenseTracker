package pl.jtrawnicki.expensetracker.expense.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jtrawnicki.expensetracker.category.domain.model.Category;
import pl.jtrawnicki.expensetracker.category.domain.repository.CategoryRepository;
import pl.jtrawnicki.expensetracker.category.service.CategoryService;
import pl.jtrawnicki.expensetracker.expense.domain.model.Expense;
import pl.jtrawnicki.expensetracker.expense.domain.repository.ExpenseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final CategoryRepository categoryRepository;

    public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Expense> getExpenses(UUID categoryId) {
        return expenseRepository.findAllByCategoryId(categoryId);

    }

    @Transactional(readOnly = true)
    public Expense getExpense(UUID expenseId) {
        return expenseRepository.getReferenceById(expenseId);
    }

    @Transactional
    public Expense createExpense(UUID categoryId, Expense expenseRequest) {

        Expense expense = new Expense();

        expense.setName(expenseRequest.getName());


        Category category = categoryRepository.getReferenceById(categoryId);

        category.addExpense(expense);

        expenseRepository.save(expense);
        categoryRepository.save(category);

        return expense;
    }

    @Transactional
    public Expense updateExpense(UUID expenseId, Expense expenseRequest) {

        Expense expense = expenseRepository.getReferenceById(expenseId);

        expense.setName(expenseRequest.getName());

        expenseRepository.save(expense);

        return expense;
    }

    @Transactional
    public void deleteExpense(UUID expenseId) {
        expenseRepository.deleteById(expenseId);
    }



}

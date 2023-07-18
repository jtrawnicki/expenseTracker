package pl.jtrawnicki.expensetracker.expense.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jtrawnicki.expensetracker.expense.domain.model.Expense;
import pl.jtrawnicki.expensetracker.expense.service.ExpenseService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories/{category-id}/expenses")
public class ExpenseApiController {

    private ExpenseService expenseService;

    public ExpenseApiController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getExpenses(@PathVariable("category-id") UUID categoryId) {
        return expenseService.getExpenses(categoryId);
    }

    @GetMapping("{expense-id}")
    public Expense getExpense(@PathVariable("category-id") UUID categoryId, @PathVariable("expense-id") UUID expenseId) {
        return expenseService.getExpense(expenseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Expense createExpense(@PathVariable("category-id") UUID categoryId, @RequestBody Expense expense) {
        return expenseService.createExpense(categoryId, expense);
    }

    @PutMapping("{expense-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Expense updateExpense(@PathVariable("category-id") UUID categoryId, @PathVariable("expense-id") UUID expenseId, @RequestBody Expense expense) {
        return expenseService.updateExpense(expenseId, expense);
    }

    @DeleteMapping("{expense-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable("expense-id") UUID expenseId) {
        expenseService.deleteExpense(expenseId);
    }



}

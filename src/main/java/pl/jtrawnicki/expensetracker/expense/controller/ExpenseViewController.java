package pl.jtrawnicki.expensetracker.expense.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jtrawnicki.expensetracker.category.service.CategoryService;
import pl.jtrawnicki.expensetracker.expense.domain.model.Expense;
import pl.jtrawnicki.expensetracker.expense.service.ExpenseService;

import java.util.UUID;

@Controller
@RequestMapping("/categories/{category-id}/expenses")
public class ExpenseViewController {

    private ExpenseService expenseService;

    private CategoryService categoryService;

    public ExpenseViewController(ExpenseService expenseService, CategoryService categoryService) {
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String addView(@PathVariable("category-id") UUID id, Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("category", categoryService.getCategory(id));

        return "expense/add";
    }

    @PostMapping
    public String add(@PathVariable("category-id") UUID categoryId, @ModelAttribute("expense") Expense expense) {
        expenseService.createExpense(categoryId, expense);

        return "redirect:/categories/{category-id}";
    }

}

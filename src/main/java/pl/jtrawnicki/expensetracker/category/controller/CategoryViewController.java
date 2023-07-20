package pl.jtrawnicki.expensetracker.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jtrawnicki.expensetracker.category.domain.model.Category;
import pl.jtrawnicki.expensetracker.category.service.CategoryService;
import pl.jtrawnicki.expensetracker.expense.service.ExpenseService;

import java.util.UUID;

@Controller
@RequestMapping("/categories")
public class CategoryViewController {

    private CategoryService categoryService;

    private ExpenseService expenseService;

    public CategoryViewController(CategoryService categoryService, ExpenseService expenseService) {
        this.categoryService = categoryService;
        this.expenseService = expenseService;
    }

    @GetMapping
    public String indexView(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "category/index";
    }

    @GetMapping("{id}")
    public String singleView(@PathVariable UUID id, Model model) {
        model.addAttribute("expenses", expenseService.getExpenses(id));
        model.addAttribute("category", categoryService.getCategory(id));
        model.addAttribute("expense", expenseService.getExpenses(id));

        return "category/single";
    }

    @GetMapping("{id}/edit")
    public String editView(@PathVariable UUID id, Model model) {
        model.addAttribute("category", categoryService.getCategory(id));

        return "category/edit";
    }

    @PostMapping("{id}/edit")
    public String edit(@ModelAttribute("category") Category category, @PathVariable UUID id) {
        categoryService.updateCategory(id, category);

        return "redirect:/categories";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable UUID id) {
        categoryService.deleteCategory(id);

        return "redirect:/categories";
    }

    @GetMapping("/add")
    public String addView(Model model) {
        model.addAttribute("category", new Category());

        return "category/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("category") Category category) {
        categoryService.createCategory(category);

        return "redirect:/categories";
    }

}

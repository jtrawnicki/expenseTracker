package pl.jtrawnicki.expensetracker.category.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jtrawnicki.expensetracker.category.domain.model.Category;
import pl.jtrawnicki.expensetracker.category.domain.repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getCategory(UUID categoryId) {
        return categoryRepository.getReferenceById(categoryId);

    }
    @Transactional
    public Category createCategory(Category categoryRequest) {

        Category category = new Category();

        category.setName(categoryRequest.getName());

        categoryRepository.save(category);
        
        return category;
    }

    @Transactional
    public Category updateCategory(UUID id, Category categoryRequest) {

        Category category = categoryRepository.getReferenceById(id);

        category.setName(categoryRequest.getName());

        categoryRepository.save(category);

        return category;
    }

    @Transactional
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}

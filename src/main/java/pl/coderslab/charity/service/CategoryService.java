package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
public class CategoryService implements CrudService<Category> {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> showAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category showById(long id) {
        return categoryRepository.findById(id).orElseThrow(EntityExistsException::new);
    }
}

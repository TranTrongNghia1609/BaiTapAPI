package vn.iotstar.api.bai3api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.api.bai3api.entity.Category;
import vn.iotstar.api.bai3api.repo.CategoryRepository;
import vn.iotstar.api.bai3api.service.ICategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    CategoryRepository categoryRepository;
    @Autowired //
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public <S extends Category> S save(S entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public Optional<Category> findByCategoryId(Long id) {
        return categoryRepository.findByCategoryId(id);
    }

    @Override
    public void delete(Long aLong) {
        categoryRepository.deleteById(aLong);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


}

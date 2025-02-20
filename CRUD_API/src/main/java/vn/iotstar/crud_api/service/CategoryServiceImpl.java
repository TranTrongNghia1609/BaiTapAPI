package vn.iotstar.crud_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.iotstar.crud_api.entity.Categories;
import vn.iotstar.crud_api.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;
@Service

public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    //source -> Generate Constructor using Field, xóa super()
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void delete(Categories entity) {
        categoryRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Override
    public <S extends Categories> Optional<S> findOne(Example<S> example) {
        return categoryRepository.findOne(example);
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Categories> findAllById(Iterable<Long> ids) {
        return categoryRepository.findAllById(ids);
    }

    @Override
    public List<Categories> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    @Override
    public Page<Categories> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Categories> findByCategoryNameContaining(String name, Pageable pageable) {
        return categoryRepository.findByCategoryNameContaining(name, pageable);
    }

    @Override
    public List<Categories> findByCategoryNameContaining(String name) {
        return categoryRepository.findByCategoryNameContaining(name);
    }

    @Override
    public Optional<Categories> findByCategoryName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    @Override
    public <S extends Categories> S save(S entity) {
        if(entity.getCategoryId() == null) {
            return categoryRepository.save(entity);
        }else {
            Optional<Categories> opt = findById(entity.getCategoryId());
            if(opt.isPresent()) {
                if (StringUtils.isEmpty(entity.getIcon())) {
                    entity.setIcon(opt.get().getIcon());
                }else {
                    //lấy lại images cũ
                    entity.setIcon(entity.getIcon());
                }
            }
            return categoryRepository.save(entity);
        }
    }

}

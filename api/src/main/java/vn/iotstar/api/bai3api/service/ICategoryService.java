package vn.iotstar.api.bai3api.service;

import vn.iotstar.api.bai3api.entity.Category;

import java.util.List;
import java.util.Optional;


public interface ICategoryService {
    Optional<Category> findByName(String name);
    <S extends Category> S save(S entity);
    Optional<Category> findByCategoryId(Long id);
    void delete(Long aLong);
    List<Category> findAll();
}

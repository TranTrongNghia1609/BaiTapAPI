package vn.iotstar.crud_api.service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.iotstar.crud_api.entity.Categories;

public interface ICategoryService {
    void delete(Categories entity);
    void deleteById(Long id);
    long count();
    <S extends Categories> Optional<S> findOne(Example<S> example);
    Optional<Categories> findById(Long id);
    List<Categories> findAllById(Iterable<Long> ids);
    List<Categories> findAll(Sort sort);
    Page<Categories> findAll(Pageable pageable);
    List<Categories> findAll();
    Page<Categories> findByCategoryNameContaining(String name, Pageable pageable);
    List<Categories> findByCategoryNameContaining(String name);
    Optional<Categories> findByCategoryName(String name);


    <S extends Categories> S save(S entity);

}

package vn.iotstar.crud_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.crud_api.entity.Categories;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
    //Tìm Kiếm theo nội dung tên
    List<Categories> findByCategoryNameContaining(String name);
    //Tìm kiếm và Phân trang
    Page<Categories> findByCategoryNameContaining(String name, Pageable pageable);
    Optional<Categories> findByCategoryName(String name);

}

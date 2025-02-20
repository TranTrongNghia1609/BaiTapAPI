package vn.iotstar.crud_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.iotstar.crud_api.entity.Categories;
import vn.iotstar.crud_api.entity.Product;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    //Tìm Kiếm theo nội dung tên
    List<Product> findByProductNameContaining(String name);
    List<Product> findByCategory_categoryId(Long categoryId);
    //Tìm kiếm và Phân trang
    Page<Product> findByProductNameContaining(String name, Pageable pageable);
    Optional<Product> findByProductName(String name);
    Optional<Product> findByCreateDate(Date createAt);

    @Query("SELECT p FROM Product p WHERE p.createDate >= :createdAt ORDER BY p.createDate DESC")
    List<Product> findTop10ByCreateDate(@Param("createdAt") LocalDateTime createdAt);
}


package vn.iotstar.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.security.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

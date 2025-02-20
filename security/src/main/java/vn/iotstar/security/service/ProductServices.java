package vn.iotstar.security.service;

import vn.iotstar.security.entity.Product;

import java.util.List;

public interface ProductServices {
    void delete(Long id);
    Product get(Long id);
    Product save (Product product);
    List<Product> listAll();
}

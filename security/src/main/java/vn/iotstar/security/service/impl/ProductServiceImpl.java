package vn.iotstar.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iotstar.security.entity.Product;
import vn.iotstar.security.repository.ProductRepository;
import vn.iotstar.security.service.ProductServices;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductServices {
    @Autowired
    private ProductRepository repo;
    public ProductServiceImpl (ProductRepository repo) { this.repo = repo; }
    @Override
    public List<Product> listAll() { return repo.findAll(); }
    @Override
    public Product save (Product product) { return repo.save(product); }
    @Override
    public Product get (Long id) { return repo.findById(id).get(); }
    @Override
    public void delete (Long id) { repo.deleteById(id); }
}

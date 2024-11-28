package kz.letmedie.catalogue.repository;

import kz.letmedie.catalogue.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Product save(Product product);

    Optional<Product> findProductById(int productId);
    void deleteById(Integer id);

}

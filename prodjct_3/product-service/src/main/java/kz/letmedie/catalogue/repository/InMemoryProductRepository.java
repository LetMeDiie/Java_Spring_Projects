package kz.letmedie.catalogue.repository;

import kz.letmedie.catalogue.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> productList = Collections.synchronizedList(new LinkedList<>());

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);
    }

    @Override
    public Product save(Product product) {
        product.setId(productList.size()+1);
        productList.add(product);
        return product;
    }

    @Override
    public Optional<Product> findProductById(int productId) {
        return productList.stream()
                .filter(product -> Objects.equals(productId,product.getId()))
                .findFirst();
    }

    @Override
    public void deleteById(Integer id) {
        productList.removeIf(product -> Objects.equals(id,product.getId()));
    }
}

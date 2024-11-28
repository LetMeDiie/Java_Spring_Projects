package kz.letmedie.project3.client;

import kz.letmedie.project3.entity.Product;
import org.example.payload.NewProductPayload;
import org.example.payload.UpdateProductPayload;

import java.util.List;
import java.util.Optional;

public interface ProductsRestClient {
    List<Product> findAllProducts();
    Product createProduct(NewProductPayload productPayload);
    Optional<Product> findProduct(int productId);
    void updateProduct(int productId, UpdateProductPayload payload);
    void deleteProduct(int productId);
}

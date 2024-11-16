package kz.letmedie.catalogue.service;

import kz.letmedie.catalogue.entity.Product;
import kz.letmedie.catalogue.payload.NewProductPayload;
import kz.letmedie.catalogue.payload.UpdateProductPayload;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product createProduct(NewProductPayload productPayload);
    Product findProduct(int productId);

    void updateProduct(Product product,UpdateProductPayload updateProductPayload);
    void deleteProduct(Integer productId);
}

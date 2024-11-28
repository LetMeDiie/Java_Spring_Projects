package kz.letmedie.catalogue.service;

import kz.letmedie.catalogue.entity.Product;
import kz.letmedie.catalogue.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import kz.letmedie.catalogue.mapper.ProductMapper;
import kz.letmedie.catalogue.exception.exceptions.ProductNotFoundException;
import org.example.payload.NewProductPayload;
import org.example.payload.UpdateProductPayload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
         return productRepository.findAll();

    }

    @Override
    public Product createProduct(NewProductPayload productPayload) {
        Product product = ProductMapper.toProduct(productPayload);
        return productRepository.save(product);
    }

    @Override
    public Product findProduct(int productId) throws ProductNotFoundException {
        return productRepository.findProductById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id:"+productId+" not found."));
    }
    @Override
    public void updateProduct(Product product, UpdateProductPayload updateProductPayload) {
        ProductMapper.updateProductFromPayload(product,updateProductPayload);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}

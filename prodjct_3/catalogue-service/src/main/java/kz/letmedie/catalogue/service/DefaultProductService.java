package kz.letmedie.catalogue.service;

import kz.letmedie.catalogue.entity.Product;
import kz.letmedie.catalogue.mapper.ProductMapper;
import kz.letmedie.catalogue.payload.NewProductPayload;
import kz.letmedie.catalogue.payload.UpdateProductPayload;
import kz.letmedie.catalogue.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;
    private final MessageSource messageSource;

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
    public Product findProduct(int productId) {
        return productRepository.findProductById(productId)
                .orElseThrow(() -> new NoSuchElementException(
                        messageSource.getMessage("catalogue.errors.product.not_found", null, Locale.getDefault())
                ));
    }
    @Override
    public void updateProduct(Product product,UpdateProductPayload updateProductPayload) {
        ProductMapper.updateProductFromPayload(product,updateProductPayload);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}

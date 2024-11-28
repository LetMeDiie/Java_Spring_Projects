package kz.letmedie.catalogue.controller;

import jakarta.validation.Valid;
import kz.letmedie.catalogue.entity.Product;
import kz.letmedie.catalogue.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.example.payload.NewProductPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products")
public class ProductsRestController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findProduct(){
        return productService.findAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody NewProductPayload payload, BindingResult result,
                                           UriComponentsBuilder builder) throws BindException{
        if(result.hasErrors()) {
            throw new BindException(result);
        }
        Product product = productService.createProduct(payload);
        String location = builder.replacePath("/catalogue-api/products/{productId}")
                .buildAndExpand(product.getId())
                .toUriString();
        return ResponseEntity.created(URI.create(location))
                .body(product);
    }

}
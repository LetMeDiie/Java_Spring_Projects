
package kz.letmedie.catalogue.controller;
import jakarta.validation.Valid;
import kz.letmedie.catalogue.entity.Product;
import kz.letmedie.catalogue.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.example.payload.UpdateProductPayload;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("catalogue-api/products/{productId:\\d+}")
public class ProductRestController {
    private final ProductService productService;
    private final MessageSource messageSource;

    @ModelAttribute("product")
    public Product getProduct(@PathVariable("productId") int id){
        return productService.findProduct(id);
    }

    @GetMapping
    public Product findProduct(@ModelAttribute("product") Product product){
        return product;
    }

    @PatchMapping
    public ResponseEntity<?> updateProduct (@ModelAttribute("product") Product product,
                                            @Valid @RequestBody UpdateProductPayload payload,
                                            BindingResult result) throws BindException {
        if(result.hasErrors()) {
            throw new BindException(result);
        }
        productService.updateProduct(product,payload);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(@ModelAttribute("product") Product product){
        productService.deleteProduct(product.getId());
        return ResponseEntity.noContent().build();
    }
}


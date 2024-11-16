package kz.letmedie.project3.controller;

import jakarta.servlet.http.HttpServletResponse;
import kz.letmedie.project3.entity.Product;
import kz.letmedie.project3.payload.UpdateProductPayload;
import kz.letmedie.project3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/catalogue/products/{productId:\\d+}")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId){
        return productService.findProduct(productId);
    }

    @GetMapping()
    public String getProduct(){
        return "catalogue/products/product";
    }

    @GetMapping("/edit")
    public String getProductEditPage(){
        return "catalogue/products/edit";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute("product") Product product, @Validated UpdateProductPayload updateProductPayload,
                                BindingResult result, Model model){
        if(result.hasErrors()) {
            model.addAttribute("payload",updateProductPayload);
            model.addAttribute("errors",result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).toList());
            return "catalogue/products/edit";
        }
        productService.updateProduct(product,updateProductPayload);
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute("product") Product product){
        productService.deleteProduct(product.getId());
        return "redirect:/catalogue/products/list";
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(NoSuchElementException exception, Model model,
                                               HttpServletResponse response){
        model.addAttribute("error",exception.getMessage());
        response.setStatus(404);
        return "errors/404";
    }
}

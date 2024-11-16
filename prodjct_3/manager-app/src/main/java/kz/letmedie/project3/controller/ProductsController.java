package kz.letmedie.project3.controller;

import kz.letmedie.project3.entity.Product;
import kz.letmedie.project3.payload.NewProductPayload;
import kz.letmedie.project3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogue/products")
public class ProductsController {
    private final ProductService productService;

    @GetMapping("/list")
    public String getProductsList(Model model){
        model.addAttribute("products",productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("/create")
    public String getNewProductPage(){
        return "catalogue/products/create";
    }

    @PostMapping("/create")
    public String createProduct(@Validated NewProductPayload payload,
                                BindingResult result,
                                Model model){
        if(result.hasErrors()) {
            model.addAttribute("payload",payload);
            model.addAttribute("errors",result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).toList());
            return "catalogue/products/create";
        }
        Product product = productService.createProduct(payload);
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }

}

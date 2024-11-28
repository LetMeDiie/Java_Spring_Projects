package kz.letmedie.catalogue.mapper;

import kz.letmedie.catalogue.entity.Product;
import org.example.payload.NewProductPayload;
import org.example.payload.UpdateProductPayload;

public class ProductMapper {
    public static Product toProduct(NewProductPayload payload) {
        if (payload == null) {
            return null;
        }
        Product product = new Product();
        product.setDetails(payload.details());
        product.setTitle(payload.title());

        return product;
    }

    public static void updateProductFromPayload(Product product, UpdateProductPayload payload) {
        if (product != null && payload != null) {
            product.setTitle(payload.title());
            product.setDetails(payload.details());
        }
    }
}
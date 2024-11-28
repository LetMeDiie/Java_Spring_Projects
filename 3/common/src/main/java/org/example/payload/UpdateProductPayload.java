package org.example.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProductPayload(
        @NotNull(message ="{catalogue.products.update.errors.title-is-null}")
        @Size(max = 30,min=3, message = "{catalogue.products.update.errors.title-is-size-invalid}")
        String title,
        @Size(max = 1000, message = "{catalogue.products.update.errors.details-is-size-invalid}")
        String details){

}

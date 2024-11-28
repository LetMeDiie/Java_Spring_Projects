package org.example.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewProductPayload(
    @NotNull(message = "{catalogue.products.create.errors.title-is-null}")
    @Size(max = 30,min=3 , message = "{catalogue.products.create.errors.title-is-size-invalid}")
    String title,

    @Size(max = 1000,message = "{catalogue.products.create.errors.details-is-size-invalid}")
    String details){
}


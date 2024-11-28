package kz.letmedie.project3.client;

import kz.letmedie.project3.entity.Product;
import kz.letmedie.project3.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.example.payload.NewProductPayload;
import org.example.payload.UpdateProductPayload;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
public class RestClientProductsRest implements ProductsRestClient {

    private final RestClient restClient;

    private final ParameterizedTypeReference<List<Product>> TYPE =
            new ParameterizedTypeReference<>() {
            };

    @Override
    public List<Product> findAllProducts() {
        return restClient
                .get()
                .uri("/catalogue-api/products")
                .retrieve()
                .body(TYPE);
    }

    @Override
    public Product createProduct(NewProductPayload productPayload) {
        try {
            return restClient
                    .post()
                    .uri("/catalogue-api/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(productPayload)
                    .retrieve()
                    .body(Product.class);
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public Optional<Product> findProduct(int productId) {
        try {
            return Optional.of(restClient.get()
                    .uri("/catalogue-api/products/{productId}", productId)
                    .retrieve()
                    .body(Product.class));
        } catch (HttpClientErrorException.NotFound exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new NoSuchElementException(problemDetail.getDetail());
        }
    }


    @Override
    public void updateProduct(int productId, UpdateProductPayload payload) {
        try {
            restClient
                    .patch()
                    .uri("/catalogue-api/products/{productId}",productId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(payload)
                    .retrieve()
                    .toBodilessEntity();
        } catch (HttpClientErrorException.BadRequest exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
        catch (HttpClientErrorException.NotFound exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new NoSuchElementException(problemDetail.getDetail());
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try {
             restClient.delete()
                    .uri("/catalogue-api/products/{productId}", productId)
                    .retrieve()
                     .toBodilessEntity();
        } catch (HttpClientErrorException.NotFound exception) {
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new NoSuchElementException(problemDetail.getDetail());
        }
    }
}

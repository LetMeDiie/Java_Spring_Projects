package kz.letmedie.project3.config;


import kz.letmedie.project3.client.RestClientProductsRest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {
    public RestClientProductsRest productsRestController(@Value("service.catalogue.uri")String uri){
        return new RestClientProductsRest(
                RestClient.builder()
                        .baseUrl(uri)
                        .build()
        );
    }
}

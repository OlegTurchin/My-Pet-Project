package eureka.client.main.services;

import eureka.client.main.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {

    private WebClient webClient;
    private final String URL = "http://localhost:2202";

    @Override
    public void saveOrUpdateProduct(Product product) {
        webClient.put()
                .uri(URL + "/saveOrUpdate")
                .bodyValue(Product.class)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }

    @Override
    public void incrementViewCounter(Long id) {
        webClient.patch()
                .uri(URL + "/incrementViewCounter/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }

    @Override
    public Product findById(Long id) {
        return webClient.get()
                .uri(URL + "/findById/" + id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    @Override
    public void removeProduct(Long id) {
        webClient.delete()
                .uri(URL + "/delete/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }

    @Override
    public String getTopByViews() {
        return webClient.get()
                .uri(URL + "/topByViews")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @Override
    public List getProductsWithPagingAndFiltering(Integer page, String word, Integer minPrice, Integer maxPrice) {
        StringBuilder pagingAndFilteringSpecs = new StringBuilder("?" + "page=" + page);

        pagingAndFilteringSpecs.append("&word=");
        if (word != null) pagingAndFilteringSpecs.append(word);

        pagingAndFilteringSpecs.append("&minPrice=");
        if (minPrice != null) pagingAndFilteringSpecs.append(minPrice);

        pagingAndFilteringSpecs.append("&maxPrice=");
        if (maxPrice != null) pagingAndFilteringSpecs.append(maxPrice);

        return webClient.get()
                .uri(URL + "/getProductsWithPagingAndFiltering" + pagingAndFilteringSpecs)
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }
}
package eureka.client.products.controllers;

import eureka.client.products.entities.Product;
import eureka.client.products.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @RequestMapping("/saveOrUpdate")
    void saveOrUpdateProduct(Product product) {
        productService.saveOrUpdateProduct(product);
    }

    @RequestMapping("/incrementViewCounter/{id}")
    void incrementViewCounter(@PathVariable(value = "id") Long id) {
        productService.incrementViewCount(id);
    }

    @RequestMapping("/findById/{id}")
    Mono<Product> findById(@PathVariable(value = "id") Long id) {
        return Mono.just(productService.findById(id));
    }

    @RequestMapping("/delete/{id}")
    void removeProduct(@PathVariable(value = "id") Long id) {
        productService.removeProduct(id);
    }

    @RequestMapping("/topByViews")
    Mono<String> getTopByViews() {
        return Mono.just(productService.getTopByViews());
    }

    @RequestMapping("/getProductsWithPagingAndFiltering")
    Mono<List<Product>> getProductsWithPagingAndFiltering(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "word", required = false) String word,
                                                    @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                                    @RequestParam(value = "maxPrice", required = false) Integer maxPrice
    ) {
        Specification<Product> productSpecification = productService.getProductSpecification(word, minPrice, maxPrice);
        return Mono.just(productService.getProductsWithPagingAndFiltering(productSpecification,
                PageRequest.of(page - 1, 20, Sort.by("count").descending())).getContent());
    }
}
package eureka.client.main.services;

import eureka.client.main.entities.Product;

import java.util.List;

public interface ProductService {

    void saveOrUpdateProduct(Product product);

    void incrementViewCounter(Long id);

    Product findById(Long id);

    void removeProduct(Long id);

    String getTopByViews();

    List<Product> getProductsWithPagingAndFiltering(Integer page, String name, Integer minPrice, Integer maxPrice);

}

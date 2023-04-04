package eureka.client.products.services;

import eureka.client.products.entities.Product;
import eureka.client.products.repositories.ProductRepository;
import eureka.client.products.repositories.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Specification<Product> getProductSpecification(String word, Integer minPrice, Integer maxPrice) {
        Specification<Product> productSpecification = Specification.where(null);
        if (word != null) productSpecification = productSpecification.and(ProductSpecification.titleContains(word));
        if (minPrice != null)
            productSpecification = productSpecification.and(ProductSpecification.priceGreaterThenOrEqualTo(minPrice));
        if (maxPrice != null)
            productSpecification = productSpecification.and(ProductSpecification.priceLessThenOrEqualTo(maxPrice));
        return productSpecification;
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public Page<Product> getProductsWithPagingAndFiltering(Specification<Product> productSpecification, Pageable pageable){
        return productRepository.findAll(productSpecification, pageable);
    }

    public String getTopByViews(){
        List<Product> productList = productRepository.findAll();
        return productList.stream().max(Comparator.comparingInt(Product::getCount)).map(Product::getTitle).get();

    }

    public void incrementViewCount(Long id){
        Product product = productRepository.findById(id);
        System.out.println("Inside of views counter method");
        product.setCount(product.getCount() + 1);
        productRepository.save(product);

    }

    public void saveOrUpdateProduct(Product product) {
        System.out.println("Inside of save method");
        productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }
}
package org.example.services;

import org.example.entities.Product;
import org.example.repositories.ProductRepository;
import org.example.repositories.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Page<Product> getProductsWithPagingAndFiltering(Specification<Product> productSpecification, Pageable pageable){
        return productRepository.findAll(productSpecification, pageable);
    }

    public String getTopByViews(){
        List<Product> productList= (List<Product>) productRepository.findAll();
        return productList.stream().max(Comparator.comparingInt(Product::getCount)).map(Product::getTitle).get();
    }

    public void incrementViewCount(Long id){
        Optional<Product> product = productRepository.findById(id);
        product.get().setCount(product.get().getCount() + 1);
        productRepository.save(product.get());

    }

    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }
}
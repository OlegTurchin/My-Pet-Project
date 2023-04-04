package eureka.client.products.repositories;

import eureka.client.products.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findById(Long id);

    Page<Product> findAll(Specification<Product> productSpecification, Pageable pageable);

    List<Product> findAll();

    void save(Product product);

    void deleteById(Long id);
}

package eureka.client.products.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "count")
    private int count;

}
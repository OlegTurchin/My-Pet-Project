package eureka.client.security.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Data @Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id @Column(name = "id")
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}

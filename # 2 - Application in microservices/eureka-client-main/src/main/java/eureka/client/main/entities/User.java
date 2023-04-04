package eureka.client.main.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Long;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String username, String password, String firstName, String lastName, String email, String phone) {
        this(username, password, firstName, lastName, email);
        this.phone = phone;
    }

    public User(String username, String password, String firstName, String lastName, String email, String phone, Collection<Role> roles) {
        this(username, password, firstName, lastName, email, phone);
        this.roles = roles;
    }


    @Override
    public String toString() {
        if (phone == null) return firstName + " " + lastName + " " + email;
        else return firstName + " " + lastName + " " + email + " " + phone;
    }
}

package eureka.client.security.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.AUTO;

@Data @Entity @Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class AppUser {

    @Id @Column(name = "id")
    @GeneratedValue(strategy = AUTO)
    private int Long;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email") @Email
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public AppUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AppUser(String username, String password, String firstName, String lastName, String email, String phone) {
        this(username, password, firstName, lastName, email);
        this.phone = phone;
    }

    public AppUser(String username, String password, String firstName, String lastName, String email, String phone, Collection<Role> roles) {
        this(username, password, firstName, lastName, email, phone);
        this.roles = roles;
    }

    @Override
    public String toString() {
        if (phone == null) return firstName + " " + lastName + " " + email;
        else return firstName + " " + lastName + " " + email + " " + phone;
    }
}

package org.example.repositories;

import org.example.controllers.ProductController;
import org.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);

    default User getUser(ProductController productController) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = findOneByUsername(userDetails.getUsername());
        return user;
    }
}

package org.example.services;

import org.example.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
}

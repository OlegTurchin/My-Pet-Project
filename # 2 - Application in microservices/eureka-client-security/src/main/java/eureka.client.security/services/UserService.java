package eureka.client.security.services;

import eureka.client.security.entities.AppUser;
import eureka.client.security.entities.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    AppUser getUser(String username);
    void addRoleToUser(String username, String roleName);
    List<AppUser> getUsers();

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

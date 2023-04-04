package eureka.client.security.services;

import eureka.client.security.entities.AppUser;
import eureka.client.security.entities.Role;
import eureka.client.security.repositories.RoleRepository;
import eureka.client.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return userRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {} to the database", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", username, roleName);
        AppUser appUser = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if (user == null){
            log.info("User {} not found in the database", username);
            throw new UsernameNotFoundException("Invalid username or password!");
        } else {
            log.info("User {} found in the database", username);
        }
        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities (Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
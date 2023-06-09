//package eureka.client.main.services;
//
//import eureka.client.main.entities.Role;
//import eureka.client.main.entities.User;
//import eureka.client.main.repositories.UserRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class UserServiceImplementation implements UserService{
//
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public User findByUserName(String username) {
//        return userRepository.findOneByUsername(username);
//    }
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findOneByUsername(username);
//        if (user == null) throw new UsernameNotFoundException("Invalid username or password!");
//        return new org.springframework.security.core.userdetails
//                .User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities (Collection<Role> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//}

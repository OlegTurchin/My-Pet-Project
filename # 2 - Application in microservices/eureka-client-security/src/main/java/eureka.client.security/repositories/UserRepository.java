package eureka.client.security.repositories;

import eureka.client.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);

//    default AppUser getUser(MainController productController) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        AppUser user = findOneByUsername(userDetails.getUsername());
//        return user;
//    }
}

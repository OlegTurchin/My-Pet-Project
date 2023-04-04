//package eureka.client.main.repositories;
//
//import eureka.client.main.entities.User;
//import eureka.client.main.controllers.MainController;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    User findOneByUsername(String username);
//
//    default User getUser(MainController productController) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = findOneByUsername(userDetails.getUsername());
//        return user;
//    }
//}

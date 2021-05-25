package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username = :username and u.enabled=1")
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}

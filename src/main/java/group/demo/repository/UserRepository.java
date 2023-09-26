package group.demo.repository;

import group.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    Optional<User> findByUsernameAndPassword(String username, String password);
}
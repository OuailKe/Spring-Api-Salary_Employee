package Repos;

import Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}

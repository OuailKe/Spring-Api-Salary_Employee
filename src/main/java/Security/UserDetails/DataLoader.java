package Security.UserDetails;

import Entities.Role;
import Entities.Users;
import Repos.UsersRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DataLoader implements CommandLineRunner {
    private final UsersRepo userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public DataLoader(UsersRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin")==null) {
            Users user = new Users();
            user.setUsername("admin");
            user.setPassword(bCryptPasswordEncoder.encode("admin"));
            user.setRole(Role.MANAGER);
            userRepository.save(user);
        }
    }
}

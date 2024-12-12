package Controllers;

import Entities.Users;
import Services.Implementation.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.check(user);
    }

    @GetMapping("/users")
    public List<Users> findAll() {
        return userService.findAll();
    }
}

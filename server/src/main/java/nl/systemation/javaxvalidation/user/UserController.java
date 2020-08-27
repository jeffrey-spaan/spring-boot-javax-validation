package nl.systemation.javaxvalidation.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @Author Jeffrey Spaan
 * @Company Systemation
 * @Created on Thursday, August 27th, 2020
 */

@RequiredArgsConstructor
@CrossOrigin(origins="http://localhost:3000", maxAge = 3600) // Allow access from port 3000 to this API
@RestController // Mark this Java class as the controller layer
@RequestMapping("/api/users") // Link to the API access point
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PostMapping
    public void addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}") // DELETE request handler by ID
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

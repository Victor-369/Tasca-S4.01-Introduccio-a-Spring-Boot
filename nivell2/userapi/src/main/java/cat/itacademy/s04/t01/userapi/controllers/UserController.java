package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {
    private final List<User> usersList = new ArrayList<>();

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return List.copyOf(this.usersList);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable UUID id) {
        return this.usersList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @GetMapping(value = "/users", params = "name")
    public List<User> getUserByNameOrAllList(@RequestParam String name) {
        if (name == null || name.isBlank()) {
            return List.copyOf(this.usersList);
        } else {
            return this.usersList.stream()
                    .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                    .toList();
        }
    }

    @PostMapping("/users")
    public User addNewUser(@RequestBody User newUser) {
        this.usersList.add(newUser);

        return newUser;
    }
}

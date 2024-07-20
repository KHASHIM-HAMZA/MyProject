package com.fitverse.stayfiit.MyUsers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginUser) {
        Optional<User> user = userService.loginUser(loginUser.getEmail(), loginUser.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok().body(Map.of("success", true, "token", "dummy-token"));
        } else {
            return ResponseEntity.status(401).body(Map.of("success", false));
        }
    }

    @PostMapping()
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String userName,
                           @RequestParam(required = false) String Email,
                           @RequestParam(required = false) String Password) {
        userService.updateUser(userId, userName, Email, Password);
    }
}

package com.fitverse.stayfiit.MyUsers;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Optional<User> loginUser(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with Id = " + userId + " doesn't exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String userName, String email, String password) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with this Id " + userId + " does not exist"));

        if (userName != null && userName.length() > 0 &&
                !Objects.equals(user.getUserName(), userName)) {
            user.setUserName(userName);
        }

        if (email != null && email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository
                    .findUserByEmail(user.getEmail());
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
        userRepository.save(user);
    }
}

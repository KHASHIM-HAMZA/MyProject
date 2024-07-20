package com.fitverse.stayfiit.MyUsers;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT s FROM User s WHERE s.Email = ?1")
    Optional<User> findUserByEmail(String Email);

    @Query("SELECT s FROM User s WHERE s.Email = ?1 AND s.Password = ?2")
    Optional<User> findUserByEmailAndPassword(String Email, String Password);
}


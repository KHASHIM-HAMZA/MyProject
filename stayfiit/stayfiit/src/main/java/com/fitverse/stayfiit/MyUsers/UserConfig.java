package com.fitverse.stayfiit.MyUsers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){

        return args -> {

            User hyskay = new User(
                    1L,
                    "hyskay",
                    "hyskay@gmail.com",
                    "pass123"
            );
            User montana = new User(
                    2L,
                    "montana",
                    "montana@gmail.com",
                    "pass456"
            );

            repository.saveAll(
                    List.of(hyskay, montana)
            );


        };
    }
}

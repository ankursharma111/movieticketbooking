package com.ankur.bms.bookmyshowjune.services;

import com.ankur.bms.bookmyshowjune.models.*;
import com.ankur.bms.bookmyshowjune.repositories.*;
import org.springframework.stereotype.*;

import javax.swing.*;
import java.util.*;
@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User login(String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {

            // create new User for DB.
           signUp(email,password);

        }

        User user = optionalUser.get();

        String userPassword = user.getPassword();

        if (password.equals(userPassword)) {
            return user;
        }
        else{
            throw new RuntimeException("Passwords do not match");
        }


    }

    private void signUp(String email, String password) {

        User user = new User();

        user.setEmail(email);
        user.setPassword(password);

        String str[] = email.split("@",2);

        user.setUsername(str[0]);

        userRepository.save(user);

    }
}

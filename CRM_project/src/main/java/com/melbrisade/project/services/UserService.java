package com.melbrisade.project.services;

import com.melbrisade.project.entities.Users;
import com.melbrisade.project.exceptions.UsernameAlreadyExistsException;
import com.melbrisade.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users savedUser (Users newUsers) {
        try {
            newUsers.setPassword(bCryptPasswordEncoder.encode(newUsers.getPassword()));
            // Username has to be unique (exception)
            newUsers.setUsername(newUsers.getUsername());
            // Make sure that password and confirmed password match
            // We don't persist or show the confirmPassword
            newUsers.setConfirmPassword("");
            return userRepository.save(newUsers);
        }catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username " + newUsers.getUsername() + " already exists");
        }

    }
}

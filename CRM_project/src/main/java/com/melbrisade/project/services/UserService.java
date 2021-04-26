package com.melbrisade.project.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.melbrisade.project.entities.Users;
import com.melbrisade.project.exceptions.UsernameAlreadyExistsException;
import com.melbrisade.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Lazy
    private MailService emailService;
    // token
    private String tokenSecret = "my-secret-string";

    public Users savedUser (Users newUsers) {
        try {
            newUsers.setPassword(bCryptPasswordEncoder.encode(newUsers.getPassword()));
            // Username has to be unique (exception)
            newUsers.setUsername(newUsers.getUsername());
            // Make sure that password and confirmed password match
            // We don't persist or show the confirmPassword
            newUsers.setConfirmPassword("");
            Users user = userRepository.save(newUsers);

            Long userId = user.getId();
            String email = user.getEmail();
            String token = JWT.create().sign(Algorithm.HMAC256(tokenSecret));
            emailService.addEmailVerifier(userId, email, token);
            emailService.sendVerificationEmail(userId);

            return user;
        }catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username " + newUsers.getUsername() + " already exists");
        }

    }

    public void updateEmailVerified(Boolean isVerified, Long userId) {
        userRepository.updateEmailVerified(isVerified, userId);
    }

//    public void addUser(String email, String password) {
//        Users user = userRepository.addUser(email, password);
//        long userId = user.getId();
//        String token = token = JWT.create().sign(Algorithm.HMAC256(tokenSecret));
//        emailService.addEmailVerifier(userId, email, token);
//        emailService.sendVerificationEmail(userId);
//    }
}

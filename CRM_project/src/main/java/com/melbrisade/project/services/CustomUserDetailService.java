package com.melbrisade.project.services;

import com.melbrisade.project.entities.Users;
import com.melbrisade.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);

        if (users == null) {
            throw  new UsernameNotFoundException("User not found");
        }
        return users;
    }

    @Transactional
    public Users loadUserById(Long id) {
        Users users = userRepository.getById(id);
        if (users == null) {
            throw  new UsernameNotFoundException("User not found");
        }
        return users;
    }
}

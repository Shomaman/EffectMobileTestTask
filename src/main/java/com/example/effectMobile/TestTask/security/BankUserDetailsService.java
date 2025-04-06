package com.example.effectMobile.TestTask.security;

import com.example.effectMobile.TestTask.entity.User;
import com.example.effectMobile.TestTask.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public BankUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.isPresent()) {
           return new BankUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("Пользователь с таким email не найден!");
        }
    }
}

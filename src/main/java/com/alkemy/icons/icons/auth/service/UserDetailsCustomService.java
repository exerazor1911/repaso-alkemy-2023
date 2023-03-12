package com.alkemy.icons.icons.auth.service;

import com.alkemy.icons.icons.auth.dto.UserDTO;
import com.alkemy.icons.icons.auth.entity.UserEntity;
import com.alkemy.icons.icons.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserDetailsCustomService implements UserDetailsService {


    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }

        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(encoder.encode(userDTO.getPassword()));
        userEntity = userRepository.save(userEntity);

        if (userEntity != null) {
            //emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }

        return userEntity != null;
    }
}

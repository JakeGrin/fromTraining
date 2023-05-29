package com.training.sgorodecki.homework.homework23.converters;

import com.training.sgorodecki.homework.homework23.dto.UserDto;
import com.training.sgorodecki.homework.homework23.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private final PasswordEncoder encoder;

    public UserConverter(final PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public User toEntity(final UserDto userDto) {
        return new User(userDto.getLogin(), encoder.encode(userDto.getPassword()), userDto.getUserRole());
    }
}
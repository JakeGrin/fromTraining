package com.training.sgorodecki.homework.homework21.converters;

import com.training.sgorodecki.homework.homework21.dto.UserDto;
import com.training.sgorodecki.homework.homework21.entity.User;
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

    public UserDto toDto(final User user) {
        return new UserDto(user.getId(), user.getLogin(), "", user.getUserRole());
    }

    public User enrich(final User user, final UserDto userDto) {
        user.setLogin(userDto.getLogin());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setUserRole(userDto.getUserRole());

        return user;
    }
}
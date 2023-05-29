package com.training.sgorodecki.homework.homework22.services.impl;

import com.training.sgorodecki.homework.homework22.authorization.CustomUserPrincipal;
import com.training.sgorodecki.homework.homework22.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework22.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        User user = Optional.of(userDAO.getByLogin(login)).orElseThrow(()
                -> new UsernameNotFoundException("User with login " + login + " was not found"));
        return new CustomUserPrincipal(user);
    }
}
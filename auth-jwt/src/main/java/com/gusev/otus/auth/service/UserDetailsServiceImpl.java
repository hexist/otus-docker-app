package com.gusev.otus.auth.service;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User details service
 *
 * @author A. Gusev
 * @since 01 июль 2020 г.
 */
@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new User("foo", "bar", new ArrayList<>());
    }
}

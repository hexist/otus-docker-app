package com.gusev.otus.docker.service;

import java.util.List;
import java.util.Optional;

import com.gusev.otus.docker.model.User;

/**
 * User service
 *
 * @author A. Gusev
 * @since 03 май 2020 г.
 */
public interface UserService {

    List<User> all();

    Optional<User> one(Long id);

    User update(User user);

    void remove(Long id);

    User createUser(User user);
}

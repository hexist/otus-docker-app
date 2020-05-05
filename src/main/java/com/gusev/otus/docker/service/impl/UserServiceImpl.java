package com.gusev.otus.docker.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gusev.otus.docker.model.User;
import com.gusev.otus.docker.repository.UserRepository;
import com.gusev.otus.docker.service.UserService;

/**
 * {@link UserService} implementation
 *
 * @author A. Gusev
 * @since 03 май 2020 г.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> all() {
        return repository.findAll();
    }

    @Override
    public Optional<User> one(Long id) {
        return repository.findById(id);
    }

    @Override
    public User update(Long userId, User user) {
        Optional<User> oUser = repository.findById(userId);
        if (oUser.isPresent()) {
            User dbUser = oUser.get();
            dbUser.setName(user.getName());
            dbUser.setModified(user.getModified());
            return repository.save(dbUser);
        }
        return null;
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User createUser(User user) {
        final Date date = new Date();
        user.setCreated(date);
        user.setModified(date);
        return repository.save(user);
    }
}

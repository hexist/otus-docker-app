package com.gusev.otus.docker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gusev.otus.docker.model.User;
import com.gusev.otus.docker.service.UserService;

/**
 * User controller
 *
 * @author A. Gusev
 * @since 04 май 2020 г.
 */
public class UserController {

    private final UserService users;

    public UserController(UserService users) {
        this.users = users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return users.all();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return users.one(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return users.createUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return users.update(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id") Long id) {
        users.remove(id);
    }

}

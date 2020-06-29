package com.gusev.otus.docker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gusev.otus.docker.model.User;
import com.gusev.otus.docker.service.UserService;

import io.micrometer.core.annotation.Timed;

/**
 * User controller
 *
 * @author A. Gusev
 * @since 04 май 2020 г.
 */
@RestController
@RequestMapping("api/v1/users/")
public class UserController {

    private final UserService users;

    public UserController(UserService users) {
        this.users = users;
    }

    @Timed(value = "users", histogram = true)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return users.all();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return users.one(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return users.createUser(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return users.update(id, user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id") Long id) {
        users.remove(id);
    }

}

package com.gusev.otus.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusev.otus.docker.model.User;

/**
 * User repository
 *
 * @author A. Gusev
 * @since 03 май 2020 г.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}

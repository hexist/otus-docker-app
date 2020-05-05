package com.gusev.otus.docker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * User model
 *
 * @author A. Gusev
 * @since 03 май 2020 г.
 */
@Data
@Entity(name = "tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 5086368706401914486L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String name;

    @Column
    private Date created;
    @Column
    private Date modified;
    @Column
    private boolean deleted;
}

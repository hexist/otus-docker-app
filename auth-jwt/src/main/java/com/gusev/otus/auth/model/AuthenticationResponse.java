package com.gusev.otus.auth.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1274070624329092552L;

    private final String jwt;
}

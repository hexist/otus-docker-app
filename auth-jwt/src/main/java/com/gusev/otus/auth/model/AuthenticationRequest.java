package com.gusev.otus.auth.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -214064023886567634L;

    private String username;
    private String password;
}

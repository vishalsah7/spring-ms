package com.jwtauth.jwt.models;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private String name;
    private String userId;
    private String email;
}

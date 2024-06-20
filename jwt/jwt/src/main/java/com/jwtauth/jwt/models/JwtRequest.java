package com.jwtauth.jwt.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtRequest {

    private String name;
    private String password;
}

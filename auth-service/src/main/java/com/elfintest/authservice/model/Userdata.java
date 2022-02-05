package com.elfintest.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdata {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username can't be blank")
    private String username;

    @NotNull(message = "Password can't be blank")
    private String password;

    @NotNull(message = "Email can't be blank")
    private String email;

    @NotNull(message = "Phone number can't be blank")
    private Long phone;
}

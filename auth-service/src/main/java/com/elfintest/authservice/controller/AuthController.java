package com.elfintest.authservice.controller;

import com.elfintest.authservice.model.Userdata;
import com.elfintest.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping(value = "/add")
    public Userdata add(@Valid @NotNull @RequestBody Userdata userdata) {
        userdata.setPassword(encoder.encode(userdata.getPassword()));
        return userRepository.save(userdata);
    }

    @GetMapping
    public List<Userdata> findAll() {
        return userRepository.findAll();
    }
}

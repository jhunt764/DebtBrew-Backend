package com.debt_brew.backend.controllers;

import com.debt_brew.backend.models.User;
import com.debt_brew.backend.repositories.UserRepository;
import com.debt_brew.backend.services.MyUserDetailsService;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MyUserDetailsService userDetailsService;

    // Register
    @PostMapping("/registration")
    ResponseEntity<?> register(@RequestBody User newUser) throws UserException {
        if (userRepo.findUserByUsername(newUser.username) == null) {
            userDetailsService.Save(newUser);
            System.out.println("new user created " + newUser);
            return ResponseEntity.ok(userRepo.findUserByUsername(newUser.username));
        }
        return ResponseEntity.status(400).body("not valid signup info");
    }

    // Login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody User user) throws Exception {
        try {
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(403).body("incorrect username or password");
        }
        UserDetails temp = userDetailsService.loadUserByUsername(user.username);

        if (BCrypt.checkpw(user.password, temp.getPassword()) == true) {

            System.out.println("password authenticated");

            System.out.println("user Info: " + temp);

            return ResponseEntity.ok(userRepo.findUserByUsername(user.username));
        } else {
            System.out.println("Invalid Username or password");
        }
        return null;
    }
}
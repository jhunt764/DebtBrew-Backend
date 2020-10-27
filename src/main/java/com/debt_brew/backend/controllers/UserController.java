package com.debt_brew.backend.controllers;

import java.util.List;

import com.debt_brew.backend.models.User;
import com.debt_brew.backend.repositories.UserRepository;
import com.debt_brew.backend.services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MyUserDetailsService userDetailsService;

    // Register
    @PostMapping("/newuser")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        // will take in Username and password and search repository, if none found then
        // a new one will be saved to the database.

        if (userRepo.findUserByUsername(newUser.username) == null) {
            userDetailsService.Save(newUser);
            System.out.println("new User Created" + newUser);
            return ResponseEntity.ok(userRepo.findUserByUsername(newUser.username));
        } else {
            System.out.println("not able to register existing username");
            return ResponseEntity.status(400).body("not valid signup");
        }

    }

    @GetMapping("/get")
    public List<User> getAllUsers(@RequestParam User user) {
        return userRepo.findAll();
    }
    

    // // Login
    // @RequestMapping(value = "login", method = RequestMethod.POST)
    // public ResponseEntity<Object> login(@RequestBody User user) throws Exception {
    //     try {
    //         new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    //     } catch (BadCredentialsException e) {
    //         return ResponseEntity.status(403).body("incorrect username or password");
    //     }
    //     UserDetails temp = userDetailsService.loadUserByUsername(user.username);

    //     if (BCrypt.checkpw(user.password, temp.getPassword()) == true) {

    //         System.out.println("password authenticated");

    //         System.out.println("user Info: " + temp);

    //         return ResponseEntity.ok(userRepo.findUserByUsername(user.username));
    //     } else {
    //         System.out.println("Invalid Username or password");
    //     }
    //     return null;
    }
// }
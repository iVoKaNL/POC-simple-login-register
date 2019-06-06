package com.example.demoproject.controller;

import com.example.demoproject.Repository.UserRepository;
import com.example.demoproject.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller which contains all user methods
 *
 */
@RestController
@RequestMapping({"/users"})
public class UserController {


    /**
     * Connection with database
     *
     * @var UserRepository
     */
    private UserRepository repository;

    /**
     * Constructor
     *
     * Dependency injection for UserRepository to get connection to Database
     *
     * @param contactRepository
     */
    UserController(UserRepository contactRepository) {
        this.repository = contactRepository;
    }

    /**
     * @return List
     */
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    /**
     * Check if email, username and password exists and if password contains more than 6 characters
     * @param user
     * @return String | ResponseStatusException
     */
    @PostMapping(path={"/register"})
    public String Register(@Valid @RequestBody User user) {
        //check if email already exists
        if(repository.findByEmail(user.getEmail()) != null) {
            //http 404 error code
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email already exists");
        }
        repository.save(user);
        return "Account successful registered";
    }

    /**
     * User login only when email and password are correct
     * @param email
     * @param password
     * @return String | ResponseStatusException
     */
    @GetMapping(path={"/login"})
    public User Login(@RequestParam String email, String password) {
        //check if email exists
        if(repository.findByEmail(email) != null) {
            User user = repository.findByEmail(email);
            //check if password equals to given password
            if(user.getPassword().equals(password)) {
                return user;
            } else {
                //http 404 error code
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "password is incorrect");
            }
        } else {
            //http 404 error code
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no email found");
        }
    }
}

package com.example.demoproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * User JPA object
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please provide user name")
    private String userName;

    @NotEmpty(message = "Please provide email")
    private String email;

    @NotEmpty(message = "Please provide password")
    @Size(min = 6, message = "Password has contain more than six characters")
    private String password;

    /**
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return password;
    }
}


package com.sdProject.scoreDEI.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name, email, telephone, role;

    public User() {
    }

    public User(String name, String email, String telephone, String role) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.role = role;
    }
}

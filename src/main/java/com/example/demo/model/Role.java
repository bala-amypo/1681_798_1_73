package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Set<User> getUsers() { return users; }

    public void setName(String name) { this.name = name; }


    public Role() {}

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

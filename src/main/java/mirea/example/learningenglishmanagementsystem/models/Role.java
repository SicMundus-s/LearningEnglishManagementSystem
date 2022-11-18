package mirea.example.learningenglishmanagementsystem.models;

import mirea.example.learningenglishmanagementsystem.models.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}

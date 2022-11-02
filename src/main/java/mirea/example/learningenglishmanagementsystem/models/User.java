package mirea.example.learningenglishmanagementsystem.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String password;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "popular_words_id")
    private String popularWordId;

}

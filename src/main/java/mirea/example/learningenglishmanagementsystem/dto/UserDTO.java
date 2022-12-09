package mirea.example.learningenglishmanagementsystem.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email_address")
    private String emailAddress;

}
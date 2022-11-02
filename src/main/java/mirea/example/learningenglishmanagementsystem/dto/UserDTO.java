package mirea.example.learningenglishmanagementsystem.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class UserDTO {

    private String name;

    private String surname;

    private String password;

    @Column(name = "email_address")
    private String emailAddress;

}
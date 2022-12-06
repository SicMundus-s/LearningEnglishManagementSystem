package mirea.example.learningenglishmanagementsystem.repositories;

import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("""
//    select u FROM User u WHERE u.login = :username
//    """)
    Optional<User> findUserByLogin(String login);

    User findByLogin(String username);

}

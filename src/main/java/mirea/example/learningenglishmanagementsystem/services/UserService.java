package mirea.example.learningenglishmanagementsystem.services;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.Role;
import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.models.Word;
import mirea.example.learningenglishmanagementsystem.repositories.RoleRepository;
import mirea.example.learningenglishmanagementsystem.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));

        userRepository.save(user);
    }

    public User findByLogin(String username) {
        return userRepository.findByLogin(username);
    }

    @Transactional
    public void addWordToDictionary(Word word, User user) {
        user.getWords().add(word);
    }

    public String getLogin(Authentication authentication) {
        String login = null;
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            login = ((UserDetails) principal).getUsername();
        } else {
            login = principal.toString();
        }
        return login;
    }
}
